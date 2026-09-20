package com.skillexchange.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFound(UserNotFoundException userNotFoundException){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userNotFoundException.getMessage());
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<String> handleInvalidPasswprdException(InvalidPasswordException invaldiPasswordException){
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(invaldiPasswordException.getMessage());
	}

}
