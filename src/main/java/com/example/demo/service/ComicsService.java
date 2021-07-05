package com.example.demo.service;

import com.example.demo.client.ComicsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "comics", url = "${api.marvel}")
public interface ComicsService {
    @GetMapping("comics/{id}?ts=${marvel.ts}&apikey=${marvel.apikey}&hash=${marvel.hash}")
    ComicsResponse retornaComics(@PathVariable("id") String id);
}
