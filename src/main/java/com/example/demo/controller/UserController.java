package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.User;
import com.example.demo.repository.ComicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

	@Autowired
	private final UserRepository userRepository;

	@GetMapping
	public List<User> listar(){
		return userRepository.findAll();
	}

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public User adicionar(@RequestBody User user) {
		return userRepository.save(user);
	}


}
