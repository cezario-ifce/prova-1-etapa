package prova.filmes.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import prova.filmes.demo.entity.FilmesEntity;

@Repository

public interface FIlmeRepository extends JpaRepository<FilmesEntity , Integer> {

}
