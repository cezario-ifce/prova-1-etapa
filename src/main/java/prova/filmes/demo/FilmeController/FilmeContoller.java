package prova.filmes.demo.FilmeController;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova.filmes.demo.FilmeService.FilmesService;
import prova.filmes.demo.entity.FilmesEntity;

@RestController
@RequestMapping
public class FilmeContoller {
    private final FilmesService filmesService;



    @GetMapping ("/buscar")
    public FilmesEntity buscarFilme(@RequestParam (name = "id") Integer id){
        return filmesService.buscarPorId(id);
    }

    @PostMapping ("/criar")
    public ResponseEntity<FilmesEntity> criarFilme (@RequestBody FilmesEntity filme){
        return filmesService.criar(filme);
    }
    @PutMapping ("/editar")
    public ResponseEntity<?> editarFilme (@PathVariable Integer id, @RequestBody FilmesEntity filme ){
        return filmesService.editar(id, filme);
    }
    @DeleteMapping ("/deletar")
    public String deletarFilme( @RequestParam ( name = "id") Integer id){
        return filmesService.deletar(id);
    }

    public FilmeContoller (FilmesService filmesService){
        this.filmesService=filmesService;
    }

}
