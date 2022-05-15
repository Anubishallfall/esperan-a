package com.example.DesaparecidoJP.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.example.DesaparecidoJP.enums.Status;

@Entity
public class Desaparecido {

	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "Desaparecido_seq")
	@SequenceGenerator(name="Desaparecido_seq", sequenceName = "Desaparecido_seq", allocationSize=1)
	private Long id;
	
	private String nome;
	
	private String idade;
	
	private String contato;
	
	private Status status;
	
	private Byte foto;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public Byte getFoto() {
		return foto;
	}

	public void setFoto(Byte foto) {
		this.foto = foto;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
