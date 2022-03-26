package com.example.validation;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class myExceptionHandler extends RuntimeException {

    @ExceptionHandler(NumberFormatException.class)
    public String NumberFormatException(Exception e ){
        return e.getMessage();
    }

    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public String ConstraintException(Exception e ){
        return e.getMessage();
    }
}
