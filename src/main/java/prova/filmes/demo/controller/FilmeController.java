package prova.filmes.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova.filmes.demo.Entity.FilmeEntity;
import prova.filmes.demo.service.FilmeService;

@RestController
@RequestMapping("/Filme")
public class FilmeController {
    private final FilmeService FilmeService;

    @GetMapping("/buscar")
    public FilmeEntity buscarFilme(@RequestParam(name = "id")
                                     Integer id){
        return FilmeService.buscar(id);
    }

    @DeleteMapping("/apagar")
    public String apagarFilme(@RequestParam(name = "id")
                               Integer id){
        return FilmeService.deletar(id);
    }

    public FilmeController(FilmeService FilmeService) {
        this.FilmeService = FilmeService;
    }
    @PostMapping("/criar")
    public ResponseEntity<FilmeEntity>criarFilme(@RequestBody FilmeEntity filme){
        return FilmeService.criar(filme);
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> editarFilme(@PathVariable Integer id,
                                          @RequestBody FilmeEntity Filme){
        return FilmeService.editar(id, Filme);

    }
}
