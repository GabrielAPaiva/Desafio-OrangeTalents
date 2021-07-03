package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class ComicsResponse {

    private String code;
    private String status;
    private Dados data;

}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Dados {

    private List<Comics> results;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Comics {

    //private String code;
    //private String status;
    private Long id;
    private String title;
    private String isbn;
    private String description;
    private List<Prices> prices;
    private Creators creators;
    //private Dados data;

}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Creators{
    private List<Itens> items;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Itens{
    private String name;
    private String role;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Prices {
    private String type;
    private String price;

}


