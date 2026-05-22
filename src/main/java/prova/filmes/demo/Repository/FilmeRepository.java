package prova.filmes.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import prova.filmes.demo.Entity.FilmeEntity;

import java.util.List;

@Repository
public interface FilmeRepository extends
            JpaRepository<FilmeEntity, Integer>{



}
