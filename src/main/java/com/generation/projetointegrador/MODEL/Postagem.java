package com.generation.projetointegrador.MODEL;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_postagens")
public class Postagem {

    @Id
    @NotNull(message = "O id não pode ser nulo!")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O titulo não pode ser vazio")
    @Size(min = 3,max = 150, message = "O titulo não pode ser menor que 10 e maior que 150")
    private String titulo;

    @NotBlank(message = "A descrição não pode ser vazio")
    @Size(min = 3,max = 150, message = "O titulo não pode ser menor que 10 e maior que 150")
    private String descricao;

    private String link;

    @UpdateTimestamp
    private LocalDateTime data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
