package com.albertsalud.spring.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldPrinter {
	
	@Autowired
	@Qualifier("helloWorld")
	private HelloWorld helloWorld;
	
	public void print() {
		System.out.println("HelloWorldPrinter: " + this.helloWorld.greet());
	}

}
