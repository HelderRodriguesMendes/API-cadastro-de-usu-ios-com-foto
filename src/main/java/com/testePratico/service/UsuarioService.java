package com.testePratico.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.testePratico.exception.NotFound;
import com.testePratico.model.Usuario;
import com.testePratico.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	// CADASTRA OU ALTERA UM USUARIO
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	// SALVA OU ALTERA A FOTO DE UM USUARIO
	public Boolean salvarFoto(MultipartFile foto, Long id) {
		byte[] ft;

		try {
			ft = foto.getBytes();
			usuarioRepository.salvarFoto(ft, id);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	// BUSCA TODOS OS USUARIOS ATIVOS
	public List<Usuario> findAllUsuariosAtivos() {

		List<Usuario> usuarios = usuarioRepository.findAllUsuariosAtivos()
				.orElseThrow(() -> new NotFound("Registros não encontrados"));
		return usuarios;
	}

	// BUSCA USUARIOS ATIVOS POR NOME
	public List<Usuario> findAllUsuariosAtivos_nome(String nome) {

		List<Usuario> usuarios = usuarioRepository.findAllUsuariosAtivos_nome(nome)
				.orElseThrow(() -> new NotFound("Registros não encontrados"));
		return usuarios;
	}

	// DESATIVA UM USUARIO
	public Boolean desativarUsuario(Long id) {
		usuarioRepository.desativarUsuario(id);
		return true;
	}

	// ATIVA UM USUARIO
	public Boolean ativarUsuario(Long id) {
		usuarioRepository.ativarUsuario(id);
		return true;
	}

	// BUSCA TODOS OS USUARIOS DESATIVADOS
	public List<Usuario> findAllUsuariosDesativados() {

		List<Usuario> usuarios = usuarioRepository.findAllUsuariosDesativados()
				.orElseThrow(() -> new NotFound("Registros não encontrados"));
		return usuarios;
	}
}
