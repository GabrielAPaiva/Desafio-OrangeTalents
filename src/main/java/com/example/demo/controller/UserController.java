package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.UserDTO;
import com.example.demo.handlers.FalhaCadastroException;
import com.example.demo.model.User;
import com.example.demo.repository.ComicsRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;

import lombok.AllArgsConstructor;

import javax.validation.Valid;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

	@Autowired
	private final UserService service;

	@Autowired
	private final UserRepository userRepository;

	@GetMapping
	public List<User> listar(){
		return userRepository.findAll();
	}

	@PostMapping("/add")
	ResponseEntity<?> add(@RequestBody @Valid UserDTO request) throws FalhaCadastroException {

		User response = service.save(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}


}
