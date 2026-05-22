package prova.filmes.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import org.springframework.http.ResponseEntity;
import prova.filmes.demo.Entity.FilmeEntity;
import prova.filmes.demo.Repository.FilmeRepository;

import java.util.List;

@Service
public class FilmeService{
    private  FilmeRepository filmeRepository;

    public ResponseEntity<FilmeEntity> salvar(FilmeEntity filme){
        FilmeEntity entity = filmeRepository.save(filme);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    public FilmeEntity buscarPorId(Integer id){
        FilmeEntity filme = filmeRepository.findById(id).orElse(null);
        return filme;

    }
    public List<FilmeEntity> listarTodos()
    {return filmeRepository.findAll();}



    public String deletar(Integer id){
        String mensagem;
        try {
            filmeRepository.findById(id).orElseThrow(() ->
            new RuntimeException("Filme não encontrado"));

            filmeRepository.deleteById(id);
            mensagem ="Filme deletado";

            return mensagem;
    }catch (RuntimeException e){
            return e.getMessage();
        }

    }
    public ResponseEntity<?> editar(Integer id, FilmeEntity filmeAtualizado){
        try{
            FilmeEntity Filme = filmeRepository.findById(id).orElseThrow(() ->
                    new RuntimeException("Filme não encontrado"));

            if (filmeAtualizado.getTitulo() != null) {
                Filme.setTitulo(filmeAtualizado.getTitulo());
            }
            if (filmeAtualizado.getDiretor() != null){
                Filme.setDiretor(filmeAtualizado.getDiretor());
            }
            if (filmeAtualizado.getAno_lancamento() != null){
                Filme.setAno_lancamento(filmeAtualizado.getAno_lancamento());
            }
            if (filmeAtualizado.getGenero() != null){
                Filme.setGenero(filmeAtualizado.getGenero());
            }
            if (filmeAtualizado.getNota() != null){
                Filme.setNota(filmeAtualizado.getNota());
            }
            filmeRepository.save(Filme);
            return ResponseEntity.ok(Filme);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }


    }
