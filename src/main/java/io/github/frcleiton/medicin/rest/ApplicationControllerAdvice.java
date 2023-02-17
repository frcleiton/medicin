package io.github.frcleiton.medicin.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import io.github.frcleiton.medicin.rest.exception.ApiErrors;

@RestControllerAdvice
@ControllerAdvice
public class ApplicationControllerAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleValidationErrors( MethodArgumentNotValidException ex ) {
		
		BindingResult bindingResult = ex.getBindingResult();
		
		List<String> msg = bindingResult.getAllErrors()
			.stream()
			.map( objectError -> objectError.getDefaultMessage())
			.collect(Collectors.toList());
		
		return new ApiErrors(msg);
	
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<ApiErrors> handleResponseStatusException(ResponseStatusException ex) {
		
		String mensagemErro = ex.getReason();
		HttpStatus codigoStatus = ex.getStatus();
		ApiErrors apiErrors = new ApiErrors(mensagemErro);
		return new ResponseEntity<ApiErrors>(apiErrors, codigoStatus);
		
	}

}
