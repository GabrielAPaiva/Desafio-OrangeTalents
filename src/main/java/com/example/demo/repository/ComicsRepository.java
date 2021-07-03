package com.example.demo.repository;

import com.example.demo.model.setComics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicsRepository extends JpaRepository<setComics, Long> {
}
