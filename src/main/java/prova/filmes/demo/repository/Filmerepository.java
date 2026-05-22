package prova.filmes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prova.filmes.demo.entity.FilmeEntity;



@Repository
public interface Filmerepository  extends
        JpaRepository<FilmeEntity, Integer> {

}
