package com.example.demo.repository;

import com.example.demo.model.UsuarioResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<UsuarioResponse, Long> {

}
