package com.generation.projetointegrador.CONTROLLER;

import com.generation.projetointegrador.MODEL.Postagem;
import com.generation.projetointegrador.MODEL.Tema;
import com.generation.projetointegrador.REPOSITORY.PostagemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
@RequestMapping("/postagens")
@CrossOrigin(origins = " * ", allowedHeaders = " * ")
public class PostagemController {

    @Autowired
    private PostagemRepository postagemRepository;

    @GetMapping/* lista todos*/
    public ResponseEntity<List<Postagem>> getAll() {
        return ResponseEntity.ok(postagemRepository.findAll());

    }

    @GetMapping("/{id}")/*busca por iD*/
    public ResponseEntity<Postagem> getById(@PathVariable Long id) {
        return postagemRepository.findById(id)
                .map(reposta -> ResponseEntity.ok(reposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }
}