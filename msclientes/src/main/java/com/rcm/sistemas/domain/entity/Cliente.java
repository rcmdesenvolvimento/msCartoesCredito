package com.rcm.sistemas.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 11, nullable = false)
	private String cpf;

	@Column(length = 80, nullable = false)
	private String nome;

	@Column(nullable = false)
	private Integer idade;

	public Cliente(String cpf, String nome, Integer idade) {
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
	}

}
