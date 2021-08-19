package br.pucpr.servico;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ProdutoResource")
public class ProdutoResource {

    @GetMapping("/consulta/{id}")
    public Produto consulta(@PathVariable("id") int id){
        Produto p = new Produto();
        p.setId(1);
        p.setNome("ProductX");
        p.setAnoFabricacao(2021);
        p.setEan("0123456789");

        return p;
    }

    @GetMapping("/consulta")
    public Produto consulta(Produto produto){
        return produto;
    }

    @PostMapping
    public Produto incluir(@RequestBody Produto produto){
        return produto;
    }

    @PutMapping("/atualiza")
    public Produto atualiza(){
        return "Atualizando produto";
    }

    @DeleteMapping("/excluir/{id}")
    public Produto excluir(@PathVariable("id") int id){
        return excluir();
    }

}
