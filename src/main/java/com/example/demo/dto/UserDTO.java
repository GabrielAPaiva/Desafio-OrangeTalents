package com.example.demo.dto;

import com.example.demo.handlers.unique.UniqueValue;
import com.example.demo.model.User;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class UserDTO {

    @NotBlank(message = "O campo nome não pode ser nulo")
    private String nome;

    @NotBlank(message = "O campo email não pode ser nulo")
    @Email(message = "Entre com um formato de email válido")
    @UniqueValue(domainClass = User.class,fieldName = "email")
    private String email;

    @NotBlank(message = "O campo cpf não pode ser nulo")
    @CPF(message = "Cpf mal formatado ou inexistente")
    @UniqueValue(domainClass = User.class,fieldName = "cpf")
    private String cpf;

    @NotBlank(message = "O campo nascimento não pode ser nulo")
    @DateTimeFormat
    private String nascimento;

    public User toModel(){

        User user = new User();
            user.setCpf(cpf);
            user.setEmail(email);
            user.setNome(nome);

        user.setNascimento(nascimento);
        return user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
}
