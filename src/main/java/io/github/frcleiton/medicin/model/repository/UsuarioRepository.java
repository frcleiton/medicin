package io.github.frcleiton.medicin.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.frcleiton.medicin.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByUsername(String username);
	
	boolean existsByUsername(String username);

}
