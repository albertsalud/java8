package com.albertsalud.rest.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Esta clase se utiliza para dar un modelo personalizado a las excepciones lanzadas.
 * 
 * Las excepciones utilizan la clase DefaultErrorAttributes para mostrar los atributos de una excepción.
 * 
 * @author Albert Salud
 *
 */
@Getter 
@Setter 
@RequiredArgsConstructor 
@NoArgsConstructor
public class ApiError {
	
	@NonNull
	private Class<?> exceptionClass;
	
	@NonNull
	private HttpStatus estado;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime fecha = LocalDateTime.now();
	
	@NonNull
	private String mensaje;

}
