package com.example.springbootapi.controllers;

import com.example.springbootapi.exceptions.ErrorDetails;
import com.example.springbootapi.exceptions.NotEnoughMoneyException;
import com.example.springbootapi.exceptions.NotFoundIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money to process payment");
        return ResponseEntity.badRequest().body(errorDetails);
    }

    @ExceptionHandler(NotFoundIdException.class)
    public ResponseEntity<ErrorDetails> exceptionNotFoundIdHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not Found product ");
        return ResponseEntity.badRequest().body(errorDetails);
    }
}
