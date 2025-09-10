package com.ecommerce.API_gestion.exceptions.Categorie;

import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;

public class NomCategorieAlreadyExistException extends BaseException {
    public NomCategorieAlreadyExistException(String nom) {
        super("La catégorie '" + nom + " existe déjà",
              "CATEGORIE_ALREADY_EXIST",
              HttpStatus.CONFLICT);
    }
}