package com.example.demo.service;

import com.example.demo.client.ComicsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "comics", url = "http://gateway.marvel.com/v1/public/")
public interface ComicsService {
    @GetMapping("comics/{id}?ts=0&apikey=4015381154f2038b160f6ce4c421741a&hash=f221a5865e13884b339216a07b39602f")
    ComicsResponse retornaComics(@PathVariable("id") Long id);
}
