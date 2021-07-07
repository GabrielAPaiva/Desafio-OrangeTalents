package com.example.demo.model;


import com.example.demo.handlers.unique.UniqueValue;

import javax.persistence.*;
import java.math.BigDecimal;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Day getDia() {
        return dia;
    }

    public void setDia(Day dia) {
        this.dia = dia;
    }

    public Boolean getDesconto() {
        return desconto;
    }

    public void setDesconto(Boolean desconto) {
        this.desconto = desconto;
    }
}
