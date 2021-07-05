package com.example.demo.service;



import com.example.demo.dto.UserDTO;
import com.example.demo.handlers.FalhaCadastroException;
import com.example.demo.model.User;

import java.util.Optional;

public interface UserService {

    User save(UserDTO UserDTO) throws FalhaCadastroException;
}
