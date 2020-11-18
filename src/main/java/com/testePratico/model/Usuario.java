package com.testePratico.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuario")
@EqualsAndHashCode(of = { "id" })
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;

	@Column(nullable = false, columnDefinition = "varchar(30)")
	private String nome;

	@Column(nullable = false)
	private LocalDate dataNascimento;
	
	@Column(nullable = false, columnDefinition = "text")
	private String foto;
	
	private Boolean ativo;
	
	public Usuario() {}
	
}
