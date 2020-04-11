package com.albertsalud.spring.basics;

public class HelloWorldPrinter {
	
	private HelloWorld helloWorld;
	
	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}
	
	public void print() {
		System.out.println("HelloWorldPrinter: " + this.helloWorld.greet());
	}

}
