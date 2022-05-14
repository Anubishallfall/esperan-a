package com.example.DesaparecidoJP.controller.endereco.form;

import com.example.DesaparecidoJP.model.Endereco;

import lombok.NonNull;

public class EnderecoForm {

	@NonNull
	private String rua;
	@NonNull
	private String bairro;
	@NonNull
	private String cidade;

	public Endereco converte() {
		Endereco endereco = new Endereco();
		endereco.setRua(this.rua);
		endereco.setBairro(this.bairro);
		endereco.setCidade(this.cidade);
		return endereco;
	}

	public String getRua() {
		return rua;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

}
