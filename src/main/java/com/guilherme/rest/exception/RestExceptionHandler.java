package com.guilherme.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.guilherme.service.exception.NotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(NotFoundException e){
		StandardError error = new StandardError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidacaoErro> validacaoErro(MethodArgumentNotValidException e){
		
		ValidacaoErro errors = new ValidacaoErro("Erro ", HttpStatus.BAD_REQUEST.value());
		
		for(FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			errors.addError(new MessagemErro(fieldError.getField(), fieldError.getDefaultMessage()));
		}
		
		System.out.println(e.getCause());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
}
