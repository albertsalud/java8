package com.albertsalud.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorldPrinter {
	
	@Autowired
	private HelloWorld helloWorld;
	
	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}
	
	public void print() {
		System.out.println(this.helloWorld.greet());
	}

}
