package com.fitness.exception;

import com.fitness.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyGlobalException {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleGlobalException(MethodArgumentNotValidException ex){

        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(
                error -> errors.put(
                        error.getObjectName(),
                        error.getDefaultMessage()
                ));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleResourceAlreadyExistException(ResourceAlreadyExistException ex){

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());

        return new ResponseEntity<>(exceptionResponse,HttpStatus.ALREADY_REPORTED);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException ex){

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());

        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }


}
