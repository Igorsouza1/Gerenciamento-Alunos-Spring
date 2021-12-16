package com.example.demo.enums;

public enum StatusEnum {
	
	ATIVO("Ativo"),
	INATIVO("Inativo"),
	TRANCADO("Trancado"),
	CANCELADO("Cancelado");
	
	private String status;
	
	private StatusEnum(String status) {
		this.status = status;
	}
}
