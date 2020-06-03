package com.albertsalud.security.errors.exceptions;

public class DuplicatedUserException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicatedUserException() {
		super("Ya existe un usuario con ese nombre en base de datos");
	}
}
