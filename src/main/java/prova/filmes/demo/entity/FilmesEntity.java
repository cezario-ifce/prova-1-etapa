package prova.filmes.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;



@Entity
@Table(name ="Filme")
@Data

public class FilmesEntity {
    @Id
    @GeneratedValue ( strategy = GenerationType. IDENTITY)
    private Integer id;
    private String titulo;
    private String diretor;
    private Date ano_Lancamento;
    private String genero;
    private Double nota;

}
