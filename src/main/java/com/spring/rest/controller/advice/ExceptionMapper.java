package com.spring.rest.controller.advice;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.rest.dto.FieldError;

@RestControllerAdvice
public class ExceptionMapper {
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<?> handleValidationError(ValidationException ex) {
		FieldError error = new FieldError();
		error.setMessage(ex.getMessage());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

}
