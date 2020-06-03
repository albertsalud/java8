package com.albertsalud.security.services;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.albertsalud.security.dto.CreateUserDTO;
import com.albertsalud.security.errors.ApiError;
import com.albertsalud.security.errors.exceptions.DuplicatedUserException;
import com.albertsalud.security.errors.exceptions.NewUserWithDifferentPasswordException;
import com.albertsalud.security.model.UserEntity;
import com.albertsalud.security.model.UserRole;
import com.albertsalud.security.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServices extends BaseService<UserEntity, Long, UserRepository>{
	
	private final PasswordEncoder passwordEncoder;
	
	public Optional<UserEntity> findByUserName(String username){
		return this.repository.findByUsername(username);
	}
	
	public UserEntity createNewUser(CreateUserDTO user) {
		if(!user.getPassword().equals(user.getRepeatedPassword())) throw new NewUserWithDifferentPasswordException();
		
		try {
			return this.save(UserEntity.builder()
				.username(user.getUsername())
				.password(passwordEncoder.encode(user.getPassword()))
				.avatar(user.getAvatar())
				.roles(Stream.of(UserRole.USER).collect(Collectors.toSet()))
				.build());
		} catch (Exception e) {
			throw new DuplicatedUserException();
		}
	}
	
	@ExceptionHandler(DuplicatedUserException.class)
	public ResponseEntity<ApiError> processSQLException() {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(
					ApiError.builder()
						.estado(HttpStatus.BAD_REQUEST)
						.mensaje("El usuario ya existe en base de datos")
						.build()
					
				);
	}

}
