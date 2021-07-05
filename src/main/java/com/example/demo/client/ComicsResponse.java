package com.example.demo.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class ComicsResponse {

    private String code;
    private String status;
    private Dados data;

}


