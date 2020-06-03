package com.albertsalud.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception para gestionar el tratamiento de errores en el caso de que el producto solicitado no exista
 * 
 * Al heredar de RuntimeException, no es necesario que los métodos donde se invoque lancen ninguna exception
 * 
 * @author Albert Salud
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)	// (Spring) Permite indicar el código de estado que devuelve esta excepción, si se produjese
public class ProductoNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductoNotFoundException(Long id) {
		super("No se puede encontrar el producto " + id);
	}

}
