package com.testePratico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testePratico.model.Usuario;
import com.testePratico.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	// CADASTRA UM USUARIO
	@PostMapping(value = "/cadastrar", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(usuarioService.salvar(usuario), HttpStatus.CREATED);
	}

	// BUSCA TODOS OS USUARIOS ATIVOS
	@GetMapping("/usuariosAtivos")
	public ResponseEntity<List<Usuario>> findAllUsuariosAtivos() {
		return new ResponseEntity<List<Usuario>>(usuarioService.findAllUsuariosAtivos(), HttpStatus.OK);
	}

	// BUSCA USUARIOS ATIVOS POR NOME
	@GetMapping("/usuariosAtivos_NOME")
	public ResponseEntity<List<Usuario>> findAllUsuariosAtivos_nome(@RequestParam String nome) {
		return new ResponseEntity<List<Usuario>>(usuarioService.findAllUsuariosAtivos_nome(nome), HttpStatus.OK);
	}

	// ALTERA UM USUARIO
	@PutMapping("/alterar/{id}")
	public ResponseEntity<Usuario> altearar(@RequestBody Usuario usuario, @PathVariable("id") Long id) {
		usuario.setId(id);
		return new ResponseEntity<Usuario>(usuarioService.salvar(usuario), HttpStatus.OK);
	}

	// DESATIVA UM USUARIO
	@PutMapping("/desativar/{id}")
	public ResponseEntity<Boolean> desativarUsuario(@PathVariable("id") Long id) {
		return new ResponseEntity<Boolean>(usuarioService.desativarUsuario(id), HttpStatus.OK);
	}

	// ATIVAR UM USUARIO
	@PutMapping("/ativar/{id}")
	public ResponseEntity<Boolean> ativarUsuario(@PathVariable("id") Long id) {
		return new ResponseEntity<Boolean>(usuarioService.ativarUsuario(id), HttpStatus.OK);
	}

	// BUSCA TODOS OS USUARIOS DESATIVADOS
	@GetMapping("/usuariosDesativados")
	public ResponseEntity<List<Usuario>> findAllUsuariosDesativados() {
		return new ResponseEntity<List<Usuario>>(usuarioService.findAllUsuariosDesativados(), HttpStatus.OK);
	}

}
