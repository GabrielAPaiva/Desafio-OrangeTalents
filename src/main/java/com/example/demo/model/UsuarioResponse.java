package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioResponse {

    //private Long idUsuario;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
//    private String title;
//    private String isbn;
//    private String description;
    @OneToMany(mappedBy = "UsuarioResponse", targetEntity = setComics.class,cascade = CascadeType.ALL)
    private Set<setComics> comics;
//    private String creators;

//    @Override
//    public String toString() {
//        String result = String.format(
//                "User[id=%d, name='%s']%n",
//                id, nome);
//        if (comics != null) {
//            for (setComics comic : comics) {
//                result += String.format(
//                        "Book[id=%d, title='%s']%n",
//                        //setComics.getId(), setComics.getTitle());
//            }
//        }
//
//        return result;
//
//    }
}
