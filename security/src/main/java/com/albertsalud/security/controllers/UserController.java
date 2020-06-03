package com.albertsalud.security.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.albertsalud.security.dto.CreateUserDTO;
import com.albertsalud.security.dto.GetUserDTO;
import com.albertsalud.security.dto.UserDTOConverter;
import com.albertsalud.security.services.UserServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserServices userServices;
	private final UserDTOConverter userDTOConverter;
	
	@PostMapping("/createUser")
	public ResponseEntity<GetUserDTO> createUser(@RequestBody CreateUserDTO user){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(
					userDTOConverter.convertToGetUserDTO(userServices.createNewUser(user)));
		
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
