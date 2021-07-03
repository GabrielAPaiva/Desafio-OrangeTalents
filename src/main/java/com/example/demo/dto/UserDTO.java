package com.example.demo.dto;

import com.example.demo.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class UserDTO {

    @NotBlank(message = "O campo nome não pode ser nulo")
    private String nome;

    @NotBlank(message = "O campo email não pode ser nulo")
    @Email(message = "Entre com um formato de email válido")
    //@UniqueValue(domainClass = User.class,fieldName = "email")
    private String email;

    @NotBlank(message = "O campo cpf não pode ser nulo")
    @CPF(message = "Cpf mal formatado ou inexistente")
    //@UniqueValue(domainClass = User.class,fieldName = "cpf")
    private String cpf;

    @NotBlank(message = "O campo nascimento não pode ser nulo")
    @DateTimeFormat
    private String nascimento;

    public User toModel(){

        User User = com.example.demo.model.User.builder()
                .cpf(this.cpf)
                .email(this.email)
                .nome(this.nome)
                .build();

        User.setNascimento(nascimento);
        return User;
    }
}
