package com.demo.smartjob.controller;

import com.demo.smartjob.models.dto.UserDTO;
import com.demo.smartjob.models.dto.UserResponseDTO;
import com.demo.smartjob.models.service.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping( value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController {
	
	@Autowired
	private IUserService service;

	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create new user record")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Created", response = UserResponseDTO.class),
		@ApiResponse(code = 404, message = "Recurso no encontrado", response = UserResponseDTO.class),
		@ApiResponse(code = 500, message = "Error interno del servidor", response = UserResponseDTO.class)
	})
	public ResponseEntity<UserResponseDTO> create (@RequestBody @Valid UserDTO user) {
		log.info("Controller save user data");
		return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
	}

	@PatchMapping("/user")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value="Update user information")
	@ApiResponses({
			@ApiResponse(code = 200, message = "OK", response = UserResponseDTO.class),
			@ApiResponse(code = 404, message = "Recurso no encontrado", response = UserResponseDTO.class),
			@ApiResponse(code = 500, message = "Error interno del servidor", response = UserResponseDTO.class)
	})
	public void update (@RequestBody @Valid UserDTO user) {
		log.info("Controller save user data");
		service.update(user);
    }


	@GetMapping("/user/{id}")
	@ApiOperation(value="Find user by id")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Proceso exitoso", response = UserResponseDTO.class),
			@ApiResponse(code = 404, message = "Recurso no encontrado", response = UserResponseDTO.class),
			@ApiResponse(code = 500, message = "Error interno del servidor", response = UserResponseDTO.class)
	})
	public UserResponseDTO getItemById(@PathVariable Long id) {
		log.info("Controller obtain user with id {}", id);
		return service.getItemById(id);
	}

	@DeleteMapping("/user/{id}")
	@ApiOperation(value="Delete user by id")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Proceso exitoso", response = UserResponseDTO.class),
			@ApiResponse(code = 404, message = "Recurso no encontrado", response = UserResponseDTO.class),
			@ApiResponse(code = 500, message = "Error interno del servidor", response = UserResponseDTO.class)
	})
	public void delete (@PathVariable Long id) {
		log.info("Controller delete user with id {}", id);
		service.delete(id);
	}

}
