package com.example.demo.handlers;


import java.time.LocalDateTime;

public class FormErrorDTO {

    private String field;
    private String error;
    private int status;
    private LocalDateTime timeStamp;

    public FormErrorDTO(String field, String mensagem, int status, LocalDateTime time) {
        this.field = field;
        this.error = mensagem;
        this.status = status;
        this.timeStamp = time;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
