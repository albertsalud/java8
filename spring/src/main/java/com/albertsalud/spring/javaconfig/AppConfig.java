package com.albertsalud.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.albertsalud.spring.javaconfig")
public class AppConfig {
	
	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld("Hola, JavaConfig!");
	}

}
