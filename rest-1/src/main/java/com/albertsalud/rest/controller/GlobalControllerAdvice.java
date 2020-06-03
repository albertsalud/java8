package com.albertsalud.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.albertsalud.rest.error.ApiError;
import com.albertsalud.rest.error.ProductoNotFoundException;

@RestControllerAdvice // (Spring) Permite centralizar el control de excepciones en esta clase
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {
	
	Logger log = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(ProductoNotFoundException.class)	// (Spring) Permite indicar que el método gestionará las excepciones del tipo indicado
	public ResponseEntity<ApiError> handleProductoNoEncontrado(ProductoNotFoundException e){
		return this.generateResponseEntity(HttpStatus.NOT_FOUND, e);
		
	}
	
	private ResponseEntity<ApiError> generateResponseEntity(HttpStatus status, Exception e){
		
		ApiError apiError = new ApiError(e.getClass(), status, "generateResponseEntity: " + e.getMessage());
		return ResponseEntity.status(status).body(apiError);
	}
	
//	@ExceptionHandler(HttpMessageNotReadableException.class)
//	public ResponseEntity<ApiError> handleJSONMappingException(HttpMessageNotReadableException e){
//		return this.generateResponseEntity(HttpStatus.CONFLICT, e);
//		
//	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiError error = new ApiError(ex.getClass(), status, "handleExceptionInternal: " + ex.getMessage());
		return ResponseEntity.status(status).headers(headers).body(error);
	}

	
	
	
}
