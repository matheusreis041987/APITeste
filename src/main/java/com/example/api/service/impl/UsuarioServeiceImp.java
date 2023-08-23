package com.example.api.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.api.exceptions.RegraNegocioException;
import com.example.api.model.entity.Usuario;
import com.example.api.model.repository.UsuarioRepository;
import com.example.api.service.UsuarioService;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServeiceImp implements UsuarioService {

	private UsuarioRepository repository; // acesso aos métodos do BD (salvar, atualizar, buscar, etc)
	
	public UsuarioServeiceImp(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Transactional
	public Usuario autenticar(String email, String senha) {
		
		Optional<Usuario> usuario = repository.findByEmail(email);
		
		if(!usuario.isPresent()) {
			throw new RegraNegocioException("Usuário não encontrado para p emial informado");
			
		}
		
		if(!usuario.get().getSenha().equals(senha)) {
			
			throw new RegraNegocioException("Senha inválida.");
			
		}
		
		return usuario.get();
	}

	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());
		return repository.save(usuario);
	}

	@Transactional
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if (existe == true) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este email.");
		}
		
	}
	
	

}
