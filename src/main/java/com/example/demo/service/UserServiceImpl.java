package com.example.demo.service;


import com.example.demo.dto.UserDTO;
import com.example.demo.handlers.FalhaCadastroException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository usuarioRepository;

    @Override
    public User save(UserDTO usuarioDto) throws FalhaCadastroException {

        try{
            return usuarioRepository.save(usuarioDto.toModel());
        }catch(Exception e){
            System.out.println(e);
            throw new FalhaCadastroException(e.getMessage());
        }
    }

}
