package com.fitness.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class ResourceAlreadyExistException extends RuntimeException{

    public ResourceAlreadyExistException(String message){
        super(message);
    }
}
