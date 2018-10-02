package com.neha.weather_test.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class InvalidCityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleConflict(Throwable throwable) {

        return new ResponseEntity<Object>(throwable.getMessage(), BAD_REQUEST);
    }
}

