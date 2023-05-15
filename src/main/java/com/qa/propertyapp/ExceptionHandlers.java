package com.qa.propertyapp;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFoundException(EntityNotFoundException enfe) {
        return new ResponseEntity<>(enfe.getMessage(), HttpStatus.NOT_FOUND);
    }
}
