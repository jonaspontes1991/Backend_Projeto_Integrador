package com.generation.projetointegrador.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_temas")
public class Tema {
    @Id
    @NotNull(message = "O id não pode ser nulo!")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotBlank(message = "Não pode ser vazio")
    @Size(min = 10,max = 100)
    private String titulo;

    @NotBlank(message = "Não pode ser vazio")
    @Size(min = 10,max = 100)
    private String Descricao;


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
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}
