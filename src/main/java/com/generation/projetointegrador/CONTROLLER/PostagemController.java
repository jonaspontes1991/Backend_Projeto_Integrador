package com.generation.projetointegrador.CONTROLLER;

import com.generation.projetointegrador.MODEL.Postagem;
import com.generation.projetointegrador.MODEL.Tema;
import com.generation.projetointegrador.REPOSITORY.PostagemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/titulo/{titulo}")/* busca espeficifa*/
    public ResponseEntity<List<Postagem>> getByTitle(@PathVariable String titulo){
        return ResponseEntity.ok(postagemRepository.findByTituloContainingIgnoreCase(titulo));

    }

    @PostMapping/*atualizando metodo */
    public ResponseEntity postPostagem(@Valid @RequestBody Postagem postagem)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));



    }




    @PutMapping
    public ResponseEntity<Postagem> put(@Valid @RequestBody Postagem postagem){
        return postagemRepository.findById(postagem.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(postagemRepository.save(postagem)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Optional<Postagem> postagem = postagemRepository.findById(id);

        if(postagem.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        postagemRepository.deleteById(id);
    }
}