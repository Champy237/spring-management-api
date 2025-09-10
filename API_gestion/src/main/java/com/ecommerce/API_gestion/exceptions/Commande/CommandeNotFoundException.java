package com.ecommerce.API_gestion.exceptions.Commande;

import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;


public class CommandeNotFoundException extends BaseException {
    public CommandeNotFoundException(Integer id) {
        super("Commande avec l'id " + id + " non trouvée",
              "COMMANDE_NOT_FOUND",
              HttpStatus.NOT_FOUND);
    }
}
