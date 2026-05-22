package prova.filmes.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeServico {
    private final FilmeRepositorio filmeRepositorio;

    public ResponseEntity<FilmeEntidade> criar(FilmeEntidade filme){
        FilmeEntidade entidade = filmeRepositorio.save(filme);

        return ResponseEntity.status(HttpStatus.CREATED).body(entidade);
    }

    public ResponseEntity<?> Update(Integer id, FilmeEntidade filmeUpadete){
        try{
            FilmeEntidade filme = filmeRepositorio.findById(id).orElseThrow(()->
                    new RuntimeException("Filme não encontrado"));

            if (filmeUpadete.getTitulo() != null){
                filme.setTitulo(filmeUpadete.getTitulo());
            }

            if (filmeUpadete.getNota() != null){
                filme.setNota(filmeUpadete.getNota());
            }

            if (filmeUpadete.getDiretor() != null){
                filme.setDiretor(filmeUpadete.getDiretor());
            }

            if (filmeUpadete.getAnoLancamento() != null){
                filme.setAnoLancamento(filmeUpadete.getAnoLancamento());
            }

            if (filmeUpadete.getGenero() !=null){
                filme.setGenero(filmeUpadete.getGenero());
            }

            filmeRepositorio.save(filme);

            return ResponseEntity.ok(filme);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    public String deletar(Integer id){
        String mensagem;
        try{
            filmeRepositorio.findById(id).orElseThrow(()->
                    new RuntimeException("filme não encontrado"));

            filmeRepositorio.deleteById(id);
            mensagem = "Filme deletado";

            return mensagem;
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public List<FilmeEntidade> buscarTodos(){
        return  filmeRepositorio.findAll();
    }

    public FilmeServico(FilmeRepositorio filmeRepositorio) {
        this.filmeRepositorio = filmeRepositorio;
    }
}
