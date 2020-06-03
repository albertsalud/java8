package com.albertsalud.rest.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");	// Esta configuración permite la entrada de cualquier URL
				
				registry.addMapping("/producto/**")	// Esta configuracion es más restrictiva
					.allowedOrigins("http://localhost:8080")
					.allowedMethods("POST", "PUT", "GET");
				
			}
			
			
			
		};
	}

}
