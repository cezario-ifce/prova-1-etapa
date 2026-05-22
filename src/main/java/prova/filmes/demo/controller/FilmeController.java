package prova.filmes.demo.controller;

import prova.filmes.demo.entity.Filme;
import prova.filmes.demo.service.FilmeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // INDICA QUE ESSA CLASSE É UM CONTROLLER REST
@RequestMapping("/filmes") // URL BASE DOS ENDPOINTS
public class FilmeController {

    @Autowired // INJETA O SERVICE
    private FilmeService service;

    // ENDPOINT PARA SALVAR UM FILME
    @PostMapping
    public Filme salvar(@RequestBody Filme filme) {
        return service.salvar(filme);
    }

    // ENDPOINT PARA LISTAR TODOS OS FILMES
    @GetMapping
    public List<Filme> listarTodos() {
        return service.listarTodos();
    }

    // ENDPOINT PARA BUSCAR FILME POR ID
    @GetMapping("/{id}")
    public Filme buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // ENDPOINT PARA DELETAR FILME
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    // ENDPOINT PARA EDITAR FILME
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id,
                                    @RequestBody Filme filmeAtualizado) {

        return service.editar(id, filmeAtualizado);
    }
}