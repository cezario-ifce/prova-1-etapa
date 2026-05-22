package prova.filmes.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova.filmes.demo.entity.FilmeEntity;
import prova.filmes.demo.services.FilmeServices;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/Filme")
public class FilmeController {
    private final FilmeServices filmeServices;

    public FilmeController(FilmeServices filmeService) {this.filmeServices = new FilmeServices();}

    @GetMapping("buscar")
    public List<FilmeEntity> buscarFilme() {
        return Collections.singletonList(filmeServices.buscar());}

    @PatchMapping("/criar")
    public ResponseEntity<FilmeEntity> criarFilme(@RequestBody FilmeEntity filme){
        return filmeServices.criar(filme);
    }
    @DeleteMapping("/apagar")
    public String apagarMusica(@RequestParam(name = "id")
                               Integer id){
        return filmeServices.deletar(id);
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> editarFilme(@PathVariable Integer id,
                                          @RequestBody FilmeEntity filme) {
        return filmeServices.editar(id, filme);
    }
}


