package com.example.demo.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comics {

    private Long id;
    private String title;
    private String isbn;
    private String description;
    private List<Prices> prices;
    private Creators creators;

}
