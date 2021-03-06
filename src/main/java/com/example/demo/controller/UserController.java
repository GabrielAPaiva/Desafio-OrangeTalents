package com.example.demo.controller;

import com.example.demo.client.ComicsResponse;
import com.example.demo.dto.UserDTO;
import com.example.demo.handlers.FalhaCadastroException;
import com.example.demo.model.User;
import com.example.demo.service.ComicsService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/comics/")
public class UserController {

	@Autowired
	private final UserService service;

	@Autowired
	private final ComicsService comicsService;

	public UserController(UserService service, ComicsService comicsService) {
		this.service = service;
		this.comicsService = comicsService;
	}

	@PostMapping("/user/add")
	ResponseEntity<?> addUser(@RequestBody @Valid UserDTO request) throws FalhaCadastroException {

		User response = service.save(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@PostMapping("/{id}/add")
	@Transactional
	ResponseEntity<?> addComic(@PathVariable("id") Long id , @RequestParam("comic") Long comicId){

		try{
			ComicsResponse comicsResponse = comicsService.retornaComics(comicId);
			var comic  = comicsResponse.toComic();

			Optional<User> usuario = service.getUsuario(id);

			if(usuario.isPresent()){
				var response =  service.addComic(comic,usuario.get());
				return ResponseEntity.status(HttpStatus.CREATED).body(response);
			}

			return ResponseEntity.notFound().build();
		}catch (Exception e){
			return ResponseEntity.unprocessableEntity().build();
		}
	}
	@GetMapping("/user/{id}")
	ResponseEntity<?> getAllComics(@PathVariable("id") Long id ){

		Optional<User> usuario = service.getUsuario(id);

		if(usuario.isPresent()){
			return ResponseEntity.ok(usuario);
		}
		return ResponseEntity.notFound().build();
	}


}
