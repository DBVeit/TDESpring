package br.pucpr.servico;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ProdutoResource")
public class ProdutoResource {

    private ProdutoRepository repository;

    ProdutoResource(ProdutoRepository produtoRepository){
        this.repository = produtoRepository;
    }

    //Consulta por ID
    @GetMapping("/consulta/{id}")
    public ResponseEntity findById(@PathVariable("id") int id){
        return (ResponseEntity) repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    //Listagem
    @GetMapping("/consulta")
    public List findAll(){
        return repository.findAll();
    }

    //Cadastro
    @PostMapping
    public Produto incluir(@RequestBody Produto produto){
        return (Produto) repository.save(produto);
    }

    //Atualizacao
    @PutMapping("/atualiza/{id}")
    public ResponseEntity atualiza(@PathVariable("id") int id,
                                   @RequestBody Produto produto){
        return repository.findById(id)
                .map(record -> {
                   record.setNome(produto.getNome());
                   record.setAnoFabricacao(produto.getAnoFabricacao());
                   record.setEan(produto.getEan());
                   Produto atualizado = (Produto) repository.save(record);
                   return ResponseEntity.ok().body(atualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    //Exclusao
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity <?> excluir(@PathVariable("id") int id){
        return (ResponseEntity<?>) repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
