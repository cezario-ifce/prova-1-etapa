package prova.filmes.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="Filme")
@Data
public class FilmeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String diretor;
    private Date ano_lancamento;
    private String genero;
    private Float nota;

}
