package prova.filmes.demo.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova.filmes.demo.Entity.FilmeEntity;
import prova.filmes.demo.Service.FilmeService;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    private final FilmeService filmeService;

    @GetMapping("/buscar")
    public FilmeEntity buscarFilme(@RequestParam(name = "id") Integer id){
        return filmeService.buscar(id);
    }

    @PostMapping("/criar")
    public FilmeEntity criarFilme(@RequestBody FilmeEntity filme){
        return filmeService.salvar(filme);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> editarFilme(@PathVariable Integer id, @RequestBody FilmeEntity filme){
        return filmeService.editar(id, filme);
    }

    @DeleteMapping("/apagar")
    public String apagarFilme(@RequestParam(name = "id") Integer id){
        return filmeService.deletar(id);
    }

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }
}
