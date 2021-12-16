package com.example.demo.enums;

public enum CursoEnum {
	
	ADMINISTRACAO("Adminitracao"),
	INFORMATICA("Informatica"),
	CONTABILIDADE("Contabilidade"),
	PROGRAMACAO("Programacao"),
	ENFERMAGEM("Enfermagem");
	
	private String curso;
	
	private CursoEnum(String curso) {
		this.curso = curso;
	}
}