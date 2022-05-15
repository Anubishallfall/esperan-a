package com.example.DesaparecidoJP.controller.desaparecido.form;

import com.example.DesaparecidoJP.controller.endereco.form.EnderecoForm;
import com.example.DesaparecidoJP.enums.Status;
import com.example.DesaparecidoJP.model.Desaparecido;

import lombok.NonNull;


public class DesaparecidoForm {
	@NonNull
	private String nome;
	@NonNull
	private String idade;
	@NonNull
	private String contato;
	@NonNull
	private Status status;

	private Byte foto;
	@NonNull
	private EnderecoForm endereco;


	public Desaparecido converte() {
		Desaparecido Desaparecido = new Desaparecido();
		Desaparecido.setNome(this.nome);
		Desaparecido.setIdade(this.idade);
		Desaparecido.setFoto(this.foto);
		Desaparecido.setEndereco(this.endereco.converte());
		Desaparecido.setContato(this.contato);
		Desaparecido.setStatus(this.status);
		return Desaparecido;
	}

	public String getNome() {
		return nome;
	}

	public String getIdade() {
		return idade;
	}

	public Byte getFoto() {
		return foto;
	}

	public EnderecoForm getEndereco() {
		return endereco;
	}

	public String getContato() {
		return contato;
	}

	public Status getStatus() {
		return status;
	}
	

}
