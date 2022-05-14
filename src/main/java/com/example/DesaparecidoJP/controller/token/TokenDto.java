package com.example.DesaparecidoJP.controller.token;

import java.util.Date;

public class TokenDto {
private String type;
	
	private String token;
	
	private Date dataDeExpiracao;
	
	
	public TokenDto(String type, String token,  Date dataDeExpiracao) {
		this.type = type;
		this.token = token;
		this.dataDeExpiracao = dataDeExpiracao;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getDataDeExpiracao() {
		return dataDeExpiracao;
	}

	public void setDataDeExpiracao(Date dataDeExpiracao) {
		this.dataDeExpiracao = dataDeExpiracao;
	}
	

}
