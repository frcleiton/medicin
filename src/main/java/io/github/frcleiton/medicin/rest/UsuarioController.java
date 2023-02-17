package io.github.frcleiton.medicin.rest;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.frcleiton.medicin.exception.UsuarioCadastradoException;
import io.github.frcleiton.medicin.model.entity.Usuario;
import io.github.frcleiton.medicin.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UsuarioController {
	
	private final UsuarioService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private void salvar(@RequestBody @Valid Usuario usuario) {
		try {
			service.salvar(usuario);
			
		} catch (UsuarioCadastradoException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
}
