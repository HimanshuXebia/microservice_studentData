package com.student.data.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataApplicationExceptionHandler {

	@ExceptionHandler(value = { DataApplicationException.class })
	public ResponseEntity<Object> handleDataApplicationException(DataApplicationException dataApplicationException) {
		return ResponseEntity.status(dataApplicationException.getHttpStatus())
				.body(dataApplicationException.getMessage());
	}
}
