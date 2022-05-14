package com.example.DesaparecidoJP.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DesaparecidoJP.model.Usuario;

public interface IUsuarioRepository  extends JpaRepository<Usuario, Long>{

	
	Optional<Usuario> findByUsername(String username);
	
}
