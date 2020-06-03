package com.albertsalud.security.config;

import java.io.IOException;
import java.io.Writer;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.albertsalud.security.errors.ApiError;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	private final ObjectMapper mapper;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		
		response.addHeader("WWW-Authenticate", "Basic realm=\"" + this.getRealmName() + "\"");
		response.setContentType("application/json");
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		
		ApiError error = new ApiError(HttpStatus.UNAUTHORIZED, authException.getMessage());
		String jsonError = mapper.writeValueAsString(error);
		
		Writer writer = response.getWriter();
		writer.write(jsonError);
	}
	
	@PostConstruct
	public void initRealmName() {
		setRealmName("NombreDelReino"); // Necesita un nombre de reino para funcionar. Puede ser cualquiera, normalmente relacionado con el ámbito de la aplicación
	}
}
