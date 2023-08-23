package com.example.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.dto.UsuarioDto;
import com.example.api.exceptions.RegraNegocioException;
import com.example.api.model.entity.Usuario;
import com.example.api.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios") // http://localhost:8080/api/usuarios
@CrossOrigin(origins = "*")
public class UsuarioController {

	private UsuarioService service;
	
	
	public UsuarioController (UsuarioService service) {
		this.service = service;
	}
	
	private Usuario converter (UsuarioDto dto) {
		Usuario usuario = new Usuario();
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(dto.getSenha());
		usuario.setNome(dto.getNome());
		
		return usuario;
	}
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity cadastrar(@RequestBody UsuarioDto dto) {
		
		try {
			
			Usuario usuario = converter(dto);
			usuario = service.salvarUsuario(usuario);
			return ResponseEntity.ok(usuario);
			
			
		} catch (RegraNegocioException e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}
		
		
	}
	
	@PostMapping("/autenticar")
	public ResponseEntity autenticar(@RequestBody UsuarioDto dto) {
		
		try {
			
			Usuario usuarioAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
			
			return ResponseEntity.ok(usuarioAutenticado);
			
		} catch (RegraNegocioException e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}
		
		
	}
	
}
