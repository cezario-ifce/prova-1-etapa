package prova.filmes.demo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name = "filme")
@Data
public class FilmeEntidade{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String diretor;
    private Date anoLancamento;
    private String Genero;
    private Float nota;


}
