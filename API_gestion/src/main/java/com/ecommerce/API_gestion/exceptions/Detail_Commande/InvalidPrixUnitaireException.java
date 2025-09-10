package com.ecommerce.API_gestion.exceptions.Detail_Commande;

import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;

public class InvalidPrixUnitaireException extends BaseException {
    public InvalidPrixUnitaireException(Integer prix) {
        super("Le prix unitaire '" + prix + "' doit être positif",
              "INVALID_PRIX_UNITAIRE",
              HttpStatus.BAD_REQUEST);
    }
}
