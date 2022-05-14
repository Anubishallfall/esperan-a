package com.example.DesaparecidoJP.controller.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DesaparecidoJP.configuration.security.TokenService;
import com.example.DesaparecidoJP.controller.usuario.form.UsuarioForm;


@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Validated UsuarioForm usuarioForm) throws Exception {
		UsernamePasswordAuthenticationToken dadosLogin = usuarioForm.converter();
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			TokenTriangulador token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDto("Bearer", token.getToken(), token.getDataDeExpiracao()));
		} catch (AuthenticationException e) {
			  throw new Exception("E-mail ou senha inválidos"); 
		}
	}
	
}
