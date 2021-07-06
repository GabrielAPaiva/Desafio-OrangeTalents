package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Comic {

    @Id
    private Long id;

    private String title;

    private String isbn;

    @Column(columnDefinition="TEXT")
    private String description;

    private BigDecimal price;

    private String creator;

    @Enumerated(EnumType.STRING)
    private Day dia;

    private Boolean desconto;

}
