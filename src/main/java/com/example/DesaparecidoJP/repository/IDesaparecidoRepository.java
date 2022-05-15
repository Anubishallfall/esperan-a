package com.example.DesaparecidoJP.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DesaparecidoJP.model.Desaparecido;

public interface IDesaparecidoRepository  extends JpaRepository<Desaparecido, Long>{

	Optional<Desaparecido> findByIdAndUsuarioId(Long id, Long usuarioId);
	
}
