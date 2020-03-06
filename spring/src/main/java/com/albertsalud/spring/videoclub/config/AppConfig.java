package com.albertsalud.spring.videoclub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.albertsalud.spring.videoclub")
@PropertySource("classpath:videoclub.properties")
public class AppConfig {

	@Value("${videoclub.csv.sourcePath}")
	private String csvPath;
	
	@Value("${videoclub.csv.fieldsSeparator}")
	private String fieldsSeparator;
	
	@Value("${videoclub.csv.listsSeparator}")
	private String listsSeparator;

	public String getCsvPath() {
		return csvPath;
	}

	public String getFieldsSeparator() {
		return fieldsSeparator;
	}

	public String getListsSeparator() {
		return listsSeparator;
	}
	
}
