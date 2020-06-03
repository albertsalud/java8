package com.albertsalud.security.errors.exceptions;

public class NewUserWithDifferentPasswordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NewUserWithDifferentPasswordException() {
		super("La contraseña introducida no coincide");
	}

}
