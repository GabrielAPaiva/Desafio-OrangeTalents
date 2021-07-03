package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.UsuarioResponse;
import com.example.demo.model.setComics;
import com.example.demo.repository.ComicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.userRepository;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
//@RequestMapping("/v1/public/comics")
public class userController {

	@Autowired
	private final userRepository userRepository;

	@Autowired
	private final ComicsRepository comicsRepository;
	
	/*@GetMapping
	public String helo() {
		return "Olá, mundo";
	}*/
	@GetMapping
	public List<UsuarioResponse> listar(){
		return userRepository.findAll();
	}
	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public User adicionar(@RequestBody User user) {
//		return userRepository.save(user);
//	}

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponse adicionar(@RequestBody UsuarioResponse user) {
		return userRepository.save(user);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public setComics adicionarComics(@RequestBody setComics comics) {
		return comicsRepository.save(comics);
	}
}
