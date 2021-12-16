package com.example.demo.modal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;

import com.example.demo.enums.CursoEnum;
import com.example.demo.enums.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_aluno")
@Getter
@Setter
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotEmpty
	@Size(min = 2, message = "O NOME deve conter no minimo 2 Caracteres")
	private	String nome;

	@Enumerated(EnumType.STRING)
	private CursoEnum curso; 
	
	@NotEmpty
	@Size(min = 2, message = "Clique no botão GERAR para gerar uma matricula")
	private String matricula;

	@Enumerated(EnumType.STRING)
	private	StatusEnum status;
	
	@NotEmpty
	@Size(min = 4, message = "O campo TURNO deve conter no minimo 4 caracteres")
	private String turno;
}

