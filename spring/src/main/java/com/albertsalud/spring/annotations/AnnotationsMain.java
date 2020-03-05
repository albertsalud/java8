package com.albertsalud.spring.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsMain {
	
	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beansAnnotations.xml");
			
		HelloWorldPrinter printer = appContext.getBean(HelloWorldPrinter.class);
		printer.print();
		
		((ClassPathXmlApplicationContext) appContext).close();
	}

}
