package com.example.DesaparecidoJP.controller.usuario.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.DesaparecidoJP.model.Usuario;

import lombok.NonNull;

public class UsuarioForm {

	@NonNull
	private String username;
	@NonNull
	private String password;

	public Usuario converte() {
		Usuario user = new Usuario();
		user.setUsername(this.username);
		user.setPassword(new BCryptPasswordEncoder().encode(this.password));
		return user;
	}
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(username, password);
	}

	public void setPassword(String password) {
		this.password = password.trim();
	}

	public void setUsername(String username) {
		this.username = username.trim();
	}

}
