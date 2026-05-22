package prova.filmes.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeControle {
    private final FilmeServico filmeServico;

    @GetMapping("/Buscar")
    public List<FilmeEntidade> BuscarFilme(){
        return filmeServico.buscarTodos();
    }

    @PostMapping("/criar")
    public ResponseEntity<FilmeEntidade> criarFilme(@RequestBody FilmeEntidade filme){
        return filmeServico.criar(filme);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<?> Atualizar(@PathVariable Integer id,
                                          @RequestBody FilmeEntidade filmeUpadete){
        return filmeServico.Update(id, filmeUpadete);
    }

    @DeleteMapping("/apagar")
    public String ApagarFilme(@RequestParam(name = "id")
                              Integer id){
        return filmeServico.deletar(id);
    }

    public FilmeControle(FilmeServico filmeServico) {
        this.filmeServico = filmeServico;
    }
}
