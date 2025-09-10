package com.ecommerce.API_gestion.exceptions.Detail_Commande;

import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;

public class InvalidQuantiteException extends BaseException {
    public InvalidQuantiteException(Integer quantite) {
        super("La quantité '" + quantite + "' doit être au moins 1",
              "INVALID_QUANTITE",
              HttpStatus.BAD_REQUEST);
    }
}
