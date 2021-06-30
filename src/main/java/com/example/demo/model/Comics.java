package com.example.demo.model;

import java.lang.reflect.Array;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Comics {
	private int id;
	private String titulo;
	private Array price;
	private Array autores;
	private String isbn;
	private String desc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Array getPrice() {
		return price;
	}
	public void setPrice(Array price) {
		this.price = price;
	}
	public Array getAutores() {
		return autores;
	}
	public void setAutores(Array autores) {
		this.autores = autores;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
