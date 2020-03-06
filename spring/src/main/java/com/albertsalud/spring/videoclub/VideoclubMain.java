package com.albertsalud.spring.videoclub;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.albertsalud.spring.videoclub.config.AppConfig;

public class VideoclubMain {
	
	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		VideoclubMainRun runner = appContext.getBean(VideoclubMainRun.class);
		runner.run();
		
		((AnnotationConfigApplicationContext) appContext).close();
		
	}

}
