package com.albertsalud.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.albertsalud.rest.controller"))
				.paths(PathSelectors.any())
				.build().apiInfo(getApiInfo());
	}
	
	@Bean
	public ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Titulo de la Api")
				.description("Descripción de la Api")
				.contact(new Contact("Albert Salud", null, "albertsalud@gmail.com"))
				.build();
	}
}
