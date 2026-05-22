package prova.filmes.demo.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import prova.filmes.demo.Entity.FilmeEntity;
import prova.filmes.demo.Repository.FilmeRepository;
import org.springframework.http.HttpStatus;


import java.util.List;


@Service
public class FilmeService {
    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public FilmeEntity salvar(FilmeEntity filme) {
        filmeRepository.save(filme);
        return filme;
    }

    public List<FilmeEntity> listarTodos() {
        return filmeRepository.findAll();
    }

    public FilmeEntity buscar(Integer id){
        FilmeEntity filme = filmeRepository.findById(id).orElse(null);
        return filme;
    }

    public String deletar(Integer id) {
        String mensagem;
        try {
            filmeRepository.findById(id).orElseThrow(() ->
                    new RuntimeException("Filme não encontrado"));

            filmeRepository.deleteById(id);
            mensagem = "Filme deletado";

            return mensagem;
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public ResponseEntity<?> editar(Integer id, FilmeEntity filmeAtualizado){
        try{
            FilmeEntity filme = filmeRepository.findById(id).orElseThrow(() ->
                    new RuntimeException("Filme não encontrado"));

            if (filmeAtualizado.getDiretor() != null){
                filme.setDiretor(filmeAtualizado.getDiretor() );
            }

            if (filmeAtualizado.getTitulo() != null){
                filme.setTitulo(filmeAtualizado.getTitulo());
            }
            if (filmeAtualizado.getGenero() != null){
                filme.setGenero(filmeAtualizado.getGenero());
            }
            if (filmeAtualizado.getAno_lancamento() != null){
                filme.setAno_lancamento(filmeAtualizado.getAno_lancamento());
            }

            if (filmeAtualizado.getNota() != null){
                filme.setNota(filmeAtualizado.getNota());
            }

            filmeRepository.save(filme);

            return ResponseEntity.ok(filme);

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }
}

