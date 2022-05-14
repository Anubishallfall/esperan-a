package com.example.DesaparecidoJP.controller.token;

import java.util.Date;

public class TokenTriangulador {

	private String token;
	
	private Date dataDeExpiracao;

	public TokenTriangulador(String token, Date dataDeExpiracao) {
		super();
		this.token = token;
		this.dataDeExpiracao = dataDeExpiracao;
	}

	public String getToken() {
		return token;
	}

	public Date getDataDeExpiracao() {
		return dataDeExpiracao;
	}
}
