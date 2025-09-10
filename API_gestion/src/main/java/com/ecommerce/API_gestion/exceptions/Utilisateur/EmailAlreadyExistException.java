package com.ecommerce.API_gestion.exceptions.Utilisateur;

import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;

public class EmailAlreadyExistException extends BaseException{


    public EmailAlreadyExistException(String Email){

        super("Cette Email "+Email+" appartient deja a un Utilisateur  ", 
        "EMAIL_ALREARDY_EXIST", 
        HttpStatus.CONFLICT

        );
    }
    
}
