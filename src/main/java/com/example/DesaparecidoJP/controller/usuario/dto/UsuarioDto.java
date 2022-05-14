package com.example.DesaparecidoJP.controller.usuario.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.DesaparecidoJP.model.Usuario;

public class UsuarioDto {

	private Long id;

	private String username;

	private String password;

	public UsuarioDto() {

	}

	public UsuarioDto(Usuario user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Long getId() {
		return id;
	}

	public static List<UsuarioDto> convert(List<Usuario> users) {
		return users.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}

}
