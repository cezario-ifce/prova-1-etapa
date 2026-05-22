import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FilmeRepository extends
        JpaRepository<FilmeEntity, Integer> {

    List<FilmeEntity> findByGeneroOrderByNotaDesc(String genero);
}
