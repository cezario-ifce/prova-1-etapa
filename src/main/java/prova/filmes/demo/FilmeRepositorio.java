package prova.filmes.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepositorio extends
        JpaRepository<FilmeEntidade, Integer>{
    Object findAllById();
}
