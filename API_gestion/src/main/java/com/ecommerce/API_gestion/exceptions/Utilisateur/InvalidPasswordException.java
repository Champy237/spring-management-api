package com.ecommerce.API_gestion.exceptions.Utilisateur;

import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;

public class InvalidPasswordException extends BaseException {
    public InvalidPasswordException() {
        super("Mot de passe invalide ou trop court",
              "INVALID_PASSWORD",
              HttpStatus.BAD_REQUEST);
    }
}