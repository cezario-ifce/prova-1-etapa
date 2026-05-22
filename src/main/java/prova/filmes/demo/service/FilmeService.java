package prova.filmes.demo.service;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import prova.filmes.demo.Entity.FilmeEntity;
import prova.filmes.demo.repository.FilmeRepository;

@Service
public class FilmeService {

    public final FilmeRepository filmeRepository;

    public ResponseEntity<FilmeEntity> criar(FilmeEntity filme){
        FilmeEntity entity = filmeRepository.save(filme);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }
    public String deletar(Integer id) {
        String mensagem;
        try {
            filmeRepository.findById(id).orElseThrow(() ->
                    new RuntimeException("Filme não encontrado"));

            filmeRepository.deleteById(id);
            mensagem = " Filme deletado";

            return mensagem;
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
    public FilmeEntity buscar(Integer id){

        FilmeEntity filme = (FilmeEntity) filmeRepository.
                findById(id).orElse(null);
        return  filme;
    }
    public ResponseEntity<?> editar(Integer id, FilmeEntity filmeAtualizado){
        try{
            FilmeEntity filme = (FilmeEntity) filmeRepository.findById(id).orElseThrow(() ->
                    new RuntimeException("Filme não encontrada"));

            if (filmeAtualizado.getTitulo() != null){
                filme.setTitulo(filmeAtualizado.getTitulo());
            }

            if (filmeAtualizado.getDiretor() != null){
                filme.setDiretor(filmeAtualizado.getDiretor());
            }
            if (filmeAtualizado.getGenero() != null){
                filme.setGenero(filmeAtualizado.getGenero());
            }
            if (filmeAtualizado.getAno_lancamento() != null){
                filme.setAno_lancamento(filmeAtualizado.getAno_lancamento());
            }

            filmeRepository.save(filme);

            return ResponseEntity.ok(filme);

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
}
}
