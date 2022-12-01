package com.generation.projetointegrador.REPOSITORY;

import com.generation.projetointegrador.MODEL.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    public List<Postagem> findByTituloContainingIgnoreCase(@Param("titulo") String titulo);

}
