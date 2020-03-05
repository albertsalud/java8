package com.albertsalud.spring.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicsMain {
	
	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		HelloWorld helloWorld = appContext.getBean("helloWorld", HelloWorld.class);
		System.out.println(helloWorld.greet());
		
		HelloWorld helloWorld2 = appContext.getBean("helloWorld2", HelloWorld.class);
		System.out.println(helloWorld2.greet());
		
		HelloWorldPrinter printer = appContext.getBean(HelloWorldPrinter.class);
		printer.print();
		
		((ClassPathXmlApplicationContext) appContext).close();
	}

}
