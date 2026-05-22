import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
@RequiredArgsConstructor
public class FilmeController {
    private final FilmeService filmeService;
    private final FilmeRepository filmeRepository;


    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> editarFilme(@PathVariable Integer id, @RequestBody FilmeEntity filmeAtualizado) {
        return filmeService.editar(id,filmeAtualizado);
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<FilmeEntity>> buscarPorGenero(@PathVariable String genero){
        List<FilmeEntity> filme = filmeRepository.findByGeneroOrderByNotaDesc(genero);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(filme);
    }
}

