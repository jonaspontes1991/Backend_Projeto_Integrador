package com.generation.projetointegrador.MODEL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @NotNull(message = "O id não pode ser nulo!")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 3,max = 150, message = "O titulo não pode ser menor que 10 e maior que 150")
    private String nome;

    @NotBlank(message = "O usuario não pode ser vazio")
    @Size(min = 3,max = 150, message = "O titulo não pode ser menor que 10 e maior que 150")
    private String usuario;

    @NotNull(message = "A senha não pode ser nulo!")
    @Size(min = 3,max = 150, message = "O titulo não pode ser menor que 10 e maior que 150")
    private String senha;

    private String foto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
