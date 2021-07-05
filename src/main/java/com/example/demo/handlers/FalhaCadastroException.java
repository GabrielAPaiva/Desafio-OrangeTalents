package com.example.demo.handlers;

public class FalhaCadastroException extends Exception {

    public FalhaCadastroException() {
    }
    public FalhaCadastroException(String message) {
        super(message);
    }
    public FalhaCadastroException(String message, Throwable cause) {
        super(message, cause);
    }
}
