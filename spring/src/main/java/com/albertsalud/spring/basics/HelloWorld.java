package com.albertsalud.spring.basics;

public class HelloWorld {
	
	private String message;
	
	public HelloWorld() {}
	
	public HelloWorld(String message) {
		this.message = message;
	}
	
	public void setMessage(String msg) {
		this.message = msg;
	}
	
	public String greet() {
		return message;
	}

}
