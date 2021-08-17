package br.pucpr.servico;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoResource {

    @GetMapping("/consulta/{id}")
    public Aluno consulta(@PathVariable("id") int id){
        Aluno a = new Aluno();
        a.setId(1);
        a.setNome("Davi");
        a.setMatricula("3997");

        return a;
    }


}
