package com.albertsalud.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class HelloWorldPrinter {
	
	@Autowired
	@Qualifier("helloWorld")
	private HelloWorld helloWorld;
	
	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}
	
	public void print() {
		System.out.println(this.helloWorld.greet());
	}

}
