package com.example.demo.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Comics;

@FeignClient(name = "marvelAPI", url = "http://gateway.marvel.com")

public interface comicsRepository {
	
//	 @RequestMapping("v1/public/comics/{id}")
//	 Comics getComic(@PathVariable("id") int id);
	@GetMapping(value = "/v1/public/comics")
	List<Comics> getAllComics();
}
