package dev.munhoz.CastrroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public  String boasVindas() {
        return  "Essa é a minha primeira mensagem";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/create")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
       NinjaDTO novoNinja = ninjaService.criarNinja(ninja);

       return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + novoNinja.getName() + " ID: " +  novoNinja.getId());
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();

        return  ResponseEntity.ok(ninjas);
    }
    // Mostrar ninja por id (READ)
    @GetMapping("/listar/{id}")
    public  ResponseEntity<?> listarPorId(@PathVariable  Long id) {
        NinjaDTO ninja = ninjaService.findNinjaById(id);

        if (ninja != null) {
            return  ResponseEntity.ok(ninja);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o Id: " + id + " nao encontrado");
    }
    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/atualiza/{id}")
    public  ResponseEntity<?> atualizaNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {

        NinjaDTO  findNinja = ninjaService.atualizarNinja(id, ninja);
        if(findNinja != null) {
             return  ResponseEntity.ok().body(findNinja);
        }
        

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja nao encontrado");

    }


    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletaNinja(@PathVariable Long id){
       if (ninjaService.findNinjaById(id) != null) {
           ninjaService.deletarNinjaPorId(id);
           return  ResponseEntity.ok("Ninja com ID " + id + " deletado com sucesso");
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com o id " + id + " nao encontrado");
       }





    }

}
