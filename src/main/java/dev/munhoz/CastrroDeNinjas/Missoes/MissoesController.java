package dev.munhoz.CastrroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missao criada";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return  "Missao alterada com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return  "Missao deletada";
    }

    @GetMapping("/listar")
    public String listarMissao() {
        return  "Listar missao";
    }


}
