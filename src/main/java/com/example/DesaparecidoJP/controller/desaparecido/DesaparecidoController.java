package com.example.DesaparecidoJP.controller.desaparecido;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.DesaparecidoJP.controller.desaparecido.dto.DesaparecidoDto;
import com.example.DesaparecidoJP.controller.desaparecido.form.DesaparecidoForm;
import com.example.DesaparecidoJP.controller.desaparecido.form.DesaparecidoFormId;
import com.example.DesaparecidoJP.enums.Status;
import com.example.DesaparecidoJP.model.Desaparecido;
import com.example.DesaparecidoJP.model.Usuario;
import com.example.DesaparecidoJP.repository.IDesaparecidoRepository;
import com.example.DesaparecidoJP.repository.IUsuarioRepository;

@RestController
@RequestMapping("/desaparecido")
public class DesaparecidoController {
	
	
	@Autowired
	IUsuarioRepository usuarioRepository;
	
	@Autowired
	IDesaparecidoRepository desaparecidoRepository;
	
	
	@GetMapping("")
	public List<DesaparecidoDto> index() {
		return DesaparecidoDto.convert(desaparecidoRepository.findAll());
	}

	@PostMapping("")
	public ResponseEntity<DesaparecidoDto> post(@RequestBody @Validated DesaparecidoForm desaparecidoForm, UriComponentsBuilder uriBuilder) {
		Usuario usuarioContexto = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Optional<Usuario> usuario = usuarioRepository.findById(usuarioContexto.getId());
		Desaparecido desaparecido = desaparecidoForm.converte();
		desaparecido.setUsuario(usuario.get());
		desaparecidoRepository.save(desaparecido);
		URI uri = uriBuilder.path("/user/{id}").buildAndExpand(desaparecido.getId()).toUri();
		return ResponseEntity.created(uri).body(new DesaparecidoDto(desaparecido));
	}
	@PostMapping("/encontrado")
	@Transactional
	public ResponseEntity<DesaparecidoDto> status(@RequestBody @Validated DesaparecidoFormId desaparecidoFormId) {
		Usuario usuarioContexto = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Optional<Desaparecido> opitional = desaparecidoRepository.findByIdAndUsuarioId(desaparecidoFormId.getId(), usuarioContexto.getId());
		Desaparecido desaparecido = opitional.get();
		desaparecido.setStatus(Status.ENCONTRADO);
        return ResponseEntity.ok(new DesaparecidoDto(desaparecido));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Desaparecido> optional = desaparecidoRepository.findById(id);
		if (optional.isPresent()) {
			desaparecidoRepository.deleteById(id);	
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}	

}
