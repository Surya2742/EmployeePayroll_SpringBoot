package com.project.employeepayroll.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> UserNotFoundExceptionHandler(Exception ex) {
        String message = ex.getMessage();
        System.out.println(message);
        return new ResponseEntity<>(Map.of("message", message), HttpStatus.NOT_FOUND);
    }
}