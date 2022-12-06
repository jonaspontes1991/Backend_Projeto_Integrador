package com.generation.projetointegrador.REPOSITORY;

import java.util.Optional;


import com.generation.projetointegrador.MODEL.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Optional<Usuario> findByUsuario(String usuario);


}
