package com.cassiano.hubspot.integration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request){
        return new ResponseEntity<>("An error has occurred: " + exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handlerIllegalArgumentException(IllegalArgumentException exception, WebRequest request){
        return new ResponseEntity<>("Invalid Argument: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
