package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "comics")
@Data
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class setComics {

    //private String code;
    //private String status;
    //@Id
    //@GeneratedValue
    @Id
    private Long id;
    private String title;
    private String isbn;
    private String description;

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private UsuarioResponse UsuarioResponse;
    //private List<Prices> prices;
    //private Creators creators;
    //private Dados data;

}


