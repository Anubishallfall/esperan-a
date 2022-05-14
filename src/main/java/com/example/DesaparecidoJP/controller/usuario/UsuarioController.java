package com.example.DesaparecidoJP.controller.usuario;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.DesaparecidoJP.controller.usuario.dto.UsuarioDto;
import com.example.DesaparecidoJP.controller.usuario.form.UsuarioForm;
import com.example.DesaparecidoJP.model.Usuario;
import com.example.DesaparecidoJP.repository.IUsuarioRepository;


@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	IUsuarioRepository usuarioRepository;
	
	
	
	@GetMapping("")
	public List<UsuarioDto> index() {
		return UsuarioDto.convert(usuarioRepository.findAll());
	}

	@PostMapping("")
	public ResponseEntity<UsuarioDto> post(@RequestBody @Validated UsuarioForm usuarioForm,
			UriComponentsBuilder uriBuilder) {
		Usuario usuario = usuarioForm.converte();
		usuarioRepository.save(usuario);
		URI uri = uriBuilder.path("/user/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			usuarioRepository.deleteById(id);	
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}	
	
}
