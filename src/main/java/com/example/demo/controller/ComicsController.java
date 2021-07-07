package com.example.demo.controller;

import com.example.demo.client.ComicsResponse;
import com.example.demo.service.ComicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/comics/")
public class ComicsController {

    @Autowired
    private ComicsService service;


    @GetMapping("/{id}")
    ResponseEntity<?> getComics(@PathVariable("id") Long id){

        try{
            ComicsResponse comicsResponse = service.retornaComics(id);
            return ResponseEntity.ok(comicsResponse);
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity().build();
        }
    }

}
