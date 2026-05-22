package prova.filmes.demo.services;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import prova.filmes.demo.entity.FilmeEntity;
import prova.filmes.demo.repository.Filmerepository;

@Service
public class FilmeServices {
    private static Filmerepository filmerepository = null;

    public FilmeServices(Filmerepository filmerepository) {
        this.filmerepository = filmerepository;
    }

    public FilmeServices() {

    }

    public ResponseEntity<FilmeEntity> criar(FilmeEntity filme) {
        FilmeEntity entity = filmerepository.save(filme);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    public String deletar(Integer id) {
        String mensagem;
        try {
            filmerepository.findById(id).orElseThrow(() ->
                    new RuntimeException("Filme não encontrada"));

            filmerepository.deleteById(id);
            mensagem = "Filme deletada";

            return mensagem;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
    public FilmeEntity buscar(){

        SimpleJpaRepository<FilmeEntity, Integer> filmeRepository = null;
        FilmeEntity filme = filmeRepository.
                findById(buscar().getId()).orElse(null);
        return  filme;
    }

    public static ResponseEntity<?> editar(Integer id, FilmeEntity filmeAtualizado){
        return filmerepository.findById(id).map(filme -> {

            if (filmeAtualizado.getTitulo() != null) {
                filme.setTitulo(filmeAtualizado.getTitulo());
            }
            if (filmeAtualizado.getDiretor() != null) {
                filme.setDiretor(filmeAtualizado.getDiretor());
            }
            if (filmeAtualizado.getGenero() != null) {
                filme.setGenero(filmeAtualizado.getGenero());
            }
            if (filmeAtualizado.getAno_lancamento() != null){
                filme.setAno_lancamento(filmeAtualizado.getAno_lancamento());
            }
            if (filmeAtualizado.getNota() != null){
                filme.setNota(filmeAtualizado.getNota());
            }

            filmerepository.save(filme);
            return ResponseEntity.ok(filme);

        }).orElse(ResponseEntity.notFound().build());
    }
}

