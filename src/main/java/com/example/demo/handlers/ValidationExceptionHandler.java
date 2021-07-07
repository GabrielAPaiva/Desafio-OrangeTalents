package com.example.demo.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FormErrorDTO> handle(MethodArgumentNotValidException exception) {
        List<FormErrorDTO> dto = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            int status = HttpStatus.BAD_REQUEST.value();
            LocalDateTime time = LocalDateTime.now();
            FormErrorDTO erro = new FormErrorDTO(e.getField(), mensagem,status,time);
            dto.add(erro);
        });
        return dto;
    }

    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(FalhaCadastroException.class)
    public FormErrorDTO fingerPrintInvalidEncode(FalhaCadastroException exception) {
        LocalDateTime time = LocalDateTime.now();
        FormErrorDTO dto = new FormErrorDTO(exception.getClass().getName(),exception.getMessage(),422,time);
        return dto;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public FormErrorDTO comicParameterHandler(MissingServletRequestParameterException exception) {
        LocalDateTime time = LocalDateTime.now();
        FormErrorDTO dto = new FormErrorDTO(exception.getClass().getName(),exception.getMessage(),422,time);
        return dto;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public FormErrorDTO comicParameterConverter(MethodArgumentTypeMismatchException exception) {
        LocalDateTime time = LocalDateTime.now();
        FormErrorDTO dto = new FormErrorDTO(exception.getClass().getName(),exception.getMessage(),422,time);
        return dto;
    }


}
