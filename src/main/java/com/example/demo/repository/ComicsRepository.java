package com.example.demo.repository;

import com.example.demo.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicsRepository extends JpaRepository<Comic, Long> {
}
