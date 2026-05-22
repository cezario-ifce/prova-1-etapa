package prova.filmes.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Entity
@Table
@Data
public class FilmeEntity {
    @Id
    @GeneratedValue

    private Integer id;
    private String titulo;
    private String diretor;
    private Date ano_lancamento;
    private String genero;
    @Column(name = "nota")
    private Double nota;

}
