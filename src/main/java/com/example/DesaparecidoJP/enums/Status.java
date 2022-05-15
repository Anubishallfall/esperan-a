package com.example.DesaparecidoJP.enums;

	
	public enum Status {
		DESAPARECIDO("Desaparecido"), ENCONTRADO("encotrado");

		private String descricao;

	
		private Status(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
	}

	
	
	
	
	
	
	
	