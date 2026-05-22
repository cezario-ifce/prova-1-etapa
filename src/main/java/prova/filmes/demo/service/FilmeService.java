package prova.filmes.demo.service;

import prova.filmes.demo.entity.Filme;
import prova.filmes.demo.repository.FilmeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // INDICA QUE ESSA CLASSE É UM SERVICE DO SPRING
public class FilmeService {

    @Autowired // INJETA O REPOSITORY AUTOMATICAMENTE
    private FilmeRepository repository;

    // MÉTODO RESPONSÁVEL POR SALVAR UM FILME NO BANCO
    public Filme salvar(Filme filme) {
        return repository.save(filme);
    }

    // RETORNA TODOS OS FILMES CADASTRADOS
    public List<Filme> listarTodos() {
        return repository.findAll();
    }

    // BUSCA UM FILME PELO ID
    public Filme buscarPorId(Long id) {

        Optional<Filme> filme = repository.findById(id);

        // VERIFICA SE O FILME EXISTE
        if (filme.isPresent()) {
            return filme.get();
        }

        // RETORNA NULL CASO NÃO ENCONTRE
        return null;
    }

    // REMOVE UM FILME PELO ID
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // MÉTODO RESPONSÁVEL POR EDITAR OS DADOS DO FILME
    public ResponseEntity<?> editar(Long id, Filme filmeAtualizado) {

        try {

            // BUSCA O FILME PELO ID
            Filme filme = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

            // ATUALIZA SOMENTE OS CAMPOS PREENCHIDOS
            if (filmeAtualizado.getTitulo() != null) {
                filme.setTitulo(filmeAtualizado.getTitulo());
            }

            if (filmeAtualizado.getGenero() != null) {
                filme.setGenero(filmeAtualizado.getGenero());
            }

            if (filmeAtualizado.getAnoLancamento() != null) {
                filme.setAnoLancamento(filmeAtualizado.getAnoLancamento());
            }

            if (filmeAtualizado.getNota() != null) {
                filme.setNota(filmeAtualizado.getNota());
            }

            // SALVA AS ALTERAÇÕES NO BANCO
            repository.save(filme);

            // RETORNA STATUS 200 COM O FILME ATUALIZADO
            return ResponseEntity.ok(filme);

        } catch (Exception e) {

            // RETORNA ERRO CASO ACONTEÇA ALGUMA EXCEÇÃO
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}