package com.example.DesaparecidoJP.controller.desaparecido.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.DesaparecidoJP.controller.endereco.dto.EnderecoDto;
import com.example.DesaparecidoJP.controller.usuario.dto.UsuarioDto;
import com.example.DesaparecidoJP.enums.Status;
import com.example.DesaparecidoJP.model.Desaparecido;


public class DesaparecidoDto {

	private Long id;

	private String nome;

	private String idade;

	private String contato;

	private Status status;

	private Byte foto;

	private EnderecoDto endereco;

	private UsuarioDto usuario;

	public DesaparecidoDto() {
		super();
	}

	public DesaparecidoDto(Desaparecido desaparecido) {
		super();
		this.id = desaparecido.getId();
		this.nome = desaparecido.getNome();
		this.idade = desaparecido.getIdade();
		this.foto = desaparecido.getFoto();
		this.endereco = new EnderecoDto(desaparecido.getEndereco());
		this.usuario = new UsuarioDto(desaparecido.getUsuario());
		this.contato = desaparecido.getContato();
		this.status = desaparecido.getStatus();
	}

	public Long getId() {
		return id;
	}

	public String getIdade() {
		return idade;
	}

	public Byte getFoto() {
		return foto;
	}

	public EnderecoDto getEndereco() {
		return endereco;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public String getNome() {
		return nome;
	}
	

	public String getContato() {
		return contato;
	}

	public Status getStatus() {
		return status;
	}

	public static List<DesaparecidoDto> convert(List<Desaparecido> users) {
		return users.stream().map(DesaparecidoDto::new).collect(Collectors.toList());
	}

}
