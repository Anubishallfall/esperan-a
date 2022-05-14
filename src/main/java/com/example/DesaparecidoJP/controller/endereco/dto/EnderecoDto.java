package com.example.DesaparecidoJP.controller.endereco.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.DesaparecidoJP.model.Endereco;

public class EnderecoDto {

	private Long id;
	private String rua;
	private String bairro;
	private String cidade;

	public EnderecoDto() {
		super();
	}

	public EnderecoDto(Endereco endereco) {
		super();
		this.id = endereco.getId();
		this.rua = endereco.getRua();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
	}

	public Long getId() {
		return id;
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

	public static List<EnderecoDto> convert(List<Endereco> enderecos) {
		return enderecos.stream().map(EnderecoDto::new).collect(Collectors.toList());
	}

}
