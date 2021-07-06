package com.example.demo.service;


import com.example.demo.dto.UserDTO;
import com.example.demo.handlers.FalhaCadastroException;
import com.example.demo.model.Comic;
import com.example.demo.model.User;
import com.example.demo.repository.ComicsRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private ComicsRepository comicsRepository;

    @Override
    public User save(UserDTO usuarioDto) throws FalhaCadastroException {

        try{
            return usuarioRepository.save(usuarioDto.toModel());
        }catch(Exception e){
            System.out.println(e);
            throw new FalhaCadastroException(e.getMessage());
        }
    }

    @Override
    public User addComic(Comic comics, User usuario){

        var response = comicsRepository.save(comics);

        var comicList = usuario.getComics();

        if(comicList == null){
            List<Comic> listaInicial = new ArrayList<>();
            listaInicial.add(response);
            usuario.setComics(listaInicial);
        }else{
            comicList.add(response);
        }

        usuarioRepository.save(usuario);

        return  usuario;

    }

    @Override
    public Optional<User> getUsuario(Long id) {
        return usuarioRepository.findById(id);
    }

}
