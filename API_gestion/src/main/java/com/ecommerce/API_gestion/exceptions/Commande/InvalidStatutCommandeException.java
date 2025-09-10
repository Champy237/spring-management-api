package com.ecommerce.API_gestion.exceptions.Commande;

import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;

public class InvalidStatutCommandeException extends BaseException {
    public InvalidStatutCommandeException(String statut) {
        super("Le statut '" + statut + "' n'est pas valide pour une commande",
              "INVALID_STATUT_COMMANDE",
              HttpStatus.BAD_REQUEST);
    }
}