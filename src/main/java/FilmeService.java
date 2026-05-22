import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {
    private FilmeRepository filmeRepository;

    public ResponseEntity<FilmeEntity> salvar(FilmeEntity filme) {
        FilmeEntity entity = filmeRepository.save(filme);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    public List<FilmeEntity> listarTodos (){
        return filmeRepository.findAll();
    }
    public List<FilmeEntity> buscarPorId (){
        return filmeRepository.findAll();
    }
    public void deletar(Long id) {
        filmeRepository.deleteById(null);
    }

    public ResponseEntity<?> editar(Integer id, FilmeEntity filmeAtualizado){
        try {
            FilmeEntity filme = filmeRepository.findById(id).orElseThrow(() ->
                    new RuntimeException("Filme não encontrado"));
        if (filmeAtualizado.getNomeFilme() != null){
            filme.setNomeFilme(filmeAtualizado.getNomeFilme());
        }
        if (filmeAtualizado.getGenero() != null){
            filme.setGenero(filmeAtualizado. getGenero());
        }
        if (filmeAtualizado.getDataLancamento() != null){
            filme.setDataLancamento(filmeAtualizado.getDataLancamento());
        }
        filmeRepository.save(filmeAtualizado);
        return ResponseEntity.ok(filme);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }
}