package com.generation.projetointegrador.CONTROLLER;

import com.generation.projetointegrador.MODEL.Tema;
import com.generation.projetointegrador.REPOSITORY.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = " * ", allowedHeaders = " * ")
public class TemaController {

  @Autowired
  private TemaRepository temaRepository;

  @GetMapping/* lista todos*/
    public ResponseEntity<List<Tema>> getAll(){
      return ResponseEntity.ok(temaRepository.findAll());
  }

  @GetMapping("/{id}")/*busca por iD*/
    public ResponseEntity<Tema> getById(@PathVariable Long id){
      return temaRepository.findById(id)
              .map(reposta -> ResponseEntity.ok(reposta))
              .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @GetMapping("/titulo/{titulo}")/* busca espeficifa*/
  public ResponseEntity<List<Tema>> getByTitle(@PathVariable String titulo){
      return ResponseEntity.ok(temaRepository.findByTituloContainingIgnoreCase(titulo));

  }
  @PostMapping/*atualizando metodo */
  public ResponseEntity postPostagem(@Valid @RequestBody Tema tema)
  {
    return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));

  }


  @PutMapping
  public ResponseEntity<Tema> put(@Valid @RequestBody Tema tema){
    return temaRepository.findById(tema.getId())
            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
                    .body(temaRepository.save(tema)))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable long id) {
    Optional<Tema> tema = temaRepository.findById(id);

    if(tema.isEmpty())
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    temaRepository.deleteById(id);
  }


}
