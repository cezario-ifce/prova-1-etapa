package prova.filmes.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prova.filmes.demo.Entity.FilmeEntity;

@Repository

public interface FilmeRepository extends
        JpaRepository<FilmeEntity, Integer> {

}
