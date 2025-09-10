package com.ecommerce.API_gestion.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BaseException extends RuntimeException{


    private String errorCode;

    private HttpStatus httpStatus;

    public BaseException(String message, String errorCode, HttpStatus httpStatus){
        super(message);

        this.errorCode = errorCode;

        this.httpStatus = httpStatus;

    }

    
} 
