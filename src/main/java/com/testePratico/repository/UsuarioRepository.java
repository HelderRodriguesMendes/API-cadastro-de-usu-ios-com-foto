package com.testePratico.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.testePratico.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	// BUSCA TODOS OS USUARIOS ATIVOS
	@Transactional
	@Query(value = "select * from usuario where ativo = true order by nome ", nativeQuery = true)
	Optional<List<Usuario>> findAllUsuariosAtivos();

	// BUSCA USUARIOS ATIVOS POR NOME
	@Transactional
	@Query(value = "select * from usuario where ativo = true and nome like %?1% order by nome limit 100", nativeQuery = true)
	Optional<List<Usuario>> findAllUsuariosAtivos_nome(String nome);

	// DESATIVA UM USUARIO
	@Transactional
	@Modifying
	@Query(value = "update usuario set ativo = false where id = ?1", nativeQuery = true)
	public void desativarUsuario(Long id);

	// ATIVA UM USUARIO
	@Transactional
	@Modifying
	@Query(value = "update usuario set ativo = true where id = ?1", nativeQuery = true)
	public void ativarUsuario(Long id);

	// BUSCA TODOS OS USUARIOS DESATIVADOS
	@Transactional
	@Query(value = "select * from usuario where ativo = false", nativeQuery = true)
	Optional<List<Usuario>> findAllUsuariosDesativados();
}
