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

}
