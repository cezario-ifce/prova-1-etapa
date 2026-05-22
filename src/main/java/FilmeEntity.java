import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table (name = "Filme")
@Data
public class FilmeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeFilme;
    private String genero;
    private Date dataLancamento;
}
