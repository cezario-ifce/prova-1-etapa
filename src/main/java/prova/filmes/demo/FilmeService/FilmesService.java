package prova.filmes.demo.FilmeService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import prova.filmes.demo.Repository.FIlmeRepository;
import prova.filmes.demo.entity.FilmesEntity;

import java.util.List;

@Service
public class FilmesService extends FilmesEntity {
    private final FIlmeRepository filmeRepository;

    public List<FilmesEntity> buscar()  {
        List<FilmesEntity> filme = filmeRepository.findAll();
        return filme;
    }



    public ResponseEntity<FilmesEntity> criar (FilmesEntity filme){

        FilmesEntity entity =filmeRepository.save(filme);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);

    }

   public FilmesEntity buscarPorId (Integer id){

        FilmesEntity filme = filmeRepository.findById(id).orElse( null);

        return filme;

   }

    public  ResponseEntity<?> editar (Integer id , FilmesEntity filmeAtualizado){
        try {
            FilmesEntity filme = filmeRepository.findById(id).orElseThrow(()->
                    new RuntimeException("Filme não Encontrado"));
            if (filmeAtualizado.getId ()!  = null){
                filme.setId(filmeAtualizado.getId());
            }
            if(filmeAtualizado.getTitulo ()!= null){
                filme.setTitulo(filmeAtualizado.getTitulo());
            }
            if (filmeAtualizado.getDiretor()!  =null){
                filme.setDiretor(filmeAtualizado.getDiretor());
            }
            if (filmeAtualizado.getAno_Lancamento() ! = null)

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String deletar (Integer id){
        String mensagem;
        try {
            filmeRepository.findById(id).orElseThrow(()->
                    new RuntimeException("Filme não Encontrado"));

            filmeRepository.deleteById(id);
            mensagem= "Filme não Encontrado";

            return mensagem;

        } catch (RuntimeException e){
            return e.getMessage();
        }
    }



    public FilmesService(FIlmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }
}
