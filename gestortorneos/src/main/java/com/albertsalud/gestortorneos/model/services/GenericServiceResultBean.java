package com.albertsalud.gestortorneos.model.services;

public abstract class GenericServiceResultBean {
	
	public static final boolean OK = true;
	public static final boolean KO = false;
	
	protected boolean ok;
	protected String errorMessage;
	
	public boolean isOk() {
		return ok;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
}
