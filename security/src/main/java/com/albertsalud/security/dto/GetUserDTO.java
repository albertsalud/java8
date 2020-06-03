package com.albertsalud.security.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class GetUserDTO {
	
	private String username;
	private String avatar;
	private Set<String> roles; 

}
