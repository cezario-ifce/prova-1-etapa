package prova.filmes.demo.repository;

import prova.filmes.demo.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// INTERFACE RESPONSÁVEL PELA COMUNICAÇÃO COM O BANCO
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    // BUSCA FILMES PELO GÊNERO E ORDENA PELA NOTA EM ORDEM DECRESCENTE
    List<Filme> findByGeneroOrderByNotaDesc(String genero);

}