package com.example.DesaparecidoJP.controller.desaparecido.form;

import com.example.DesaparecidoJP.model.Desaparecido;

import lombok.NonNull;

public class DesaparecidoFormId {
	
	@NonNull
	private Long id;

	
	public Desaparecido converte() {
		Desaparecido Desaparecido = new Desaparecido();
		Desaparecido.setId(this.id);
		return Desaparecido;
	}
	
	public Long getId() {
		return id;
	}
}
