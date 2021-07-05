package com.example.demo.handlers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class FormErrorDTO {

    private String field;
    private String error;
    private int status;
    private LocalDateTime timeStamp;

}
