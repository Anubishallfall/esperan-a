package com.example.DesaparecidoJP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Endereco {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "endereco_seq")
	@SequenceGenerator(name="endereco_seq", sequenceName = "endereco_seq", allocationSize=1)
	private Long id;
	private String rua;
	private String bairro;
	private String cidade;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
