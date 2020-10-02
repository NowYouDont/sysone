/**
 * 
 */
package com.amediavilla.spring.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * @author amediavilla
 * 
 */
@ControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<?> productNotFoundException(ProductNotFoundException ex, WebRequest request) {
		ErrorDescription errorDesc = new ErrorDescription(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDesc, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorDescription errorDesc = new ErrorDescription(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDesc, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
