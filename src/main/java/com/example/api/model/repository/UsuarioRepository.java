package com.example.api.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
	// query methods
	
	boolean existsByEmail(String email);
	
	Optional<Usuario>findByEmail(String email_parametro);
	// select * from eletronicos.usuario where email like 'email_parametro'
}
