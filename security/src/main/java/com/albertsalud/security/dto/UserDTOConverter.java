package com.albertsalud.security.dto;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.albertsalud.security.model.UserEntity;
import com.albertsalud.security.model.UserRole;

@Component
public class UserDTOConverter {
	
	public GetUserDTO convertToGetUserDTO(UserEntity user) {
		return GetUserDTO.builder()
			.username(user.getUsername())
			.avatar(user.getAvatar())
			.roles(user.getRoles().stream().map(UserRole::name).collect(Collectors.toSet()))
			.build();
	}

}
