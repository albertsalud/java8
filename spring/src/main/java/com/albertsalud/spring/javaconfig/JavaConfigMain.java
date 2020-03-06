package com.albertsalud.spring.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigMain {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		HelloWorldPrinter printer = appContext.getBean(HelloWorldPrinter.class);
		
		printer.print();
		
		((AnnotationConfigApplicationContext) appContext).close();
		
	}
}
