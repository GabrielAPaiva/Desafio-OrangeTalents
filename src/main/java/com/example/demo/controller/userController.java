package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comics;
import com.example.demo.model.User;
import com.example.demo.repository.comicsRepository;
import com.example.demo.repository.userRepository;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
//@RequestMapping("/users")
@RequestMapping("/v1/public/comics")
public class userController {

	@Autowired
	private userRepository userRepository;
	
	private comicsRepository comicsRepository;
	//private comicsRepository comicsRepository;
	
	//@GetMapping
	//public List<Comics> listarComics(){
	//	return ;
	//}
	
	/*@GetMapping
	public String helo() {
		return "Olá, mundo";
	}*/
	@GetMapping
	public List<User> listar(){
		return userRepository.findAll();
	}
	
//	@GetMapping
//	public List<Comics> comicsList(){
//		return comicsRepository.findAll();
//	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User adicionar(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	 /*@ResponseStatus(HttpStatus.OK)
	 @RequestMapping(value = "", method = RequestMethod.GET)
	 public Comics getComic(@PathVariable List<Comics> comics) {
		return comicsRepository.getComic(comics);
	 }*/
//	 @ResponseStatus(HttpStatus.OK)
//	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	 public Comics getComic(@PathVariable int comic) {
//		return comicsRepository.getComic(comic);
//	 }
	 @GetMapping
	 List<Comics> getAllComics(){
		 return comicsRepository.getAllComics();
	 }
}
