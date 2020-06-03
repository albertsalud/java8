package com.albertsalud.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor  @AllArgsConstructor
@Builder
public class CreateUserDTO {

	private String username;
	private String password;
	private String repeatedPassword;
	private String avatar;
	
}
