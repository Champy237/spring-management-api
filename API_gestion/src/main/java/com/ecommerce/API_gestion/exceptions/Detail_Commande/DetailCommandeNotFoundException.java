package com.ecommerce.API_gestion.exceptions.Detail_Commande;

import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;

public class DetailCommandeNotFoundException extends BaseException {
    public DetailCommandeNotFoundException(Integer id) {
        super("Détail de commande avec l'id " + id + " non trouvé",
              "DETAIL_COMMANDE_NOT_FOUND",
              HttpStatus.NOT_FOUND);
    }
}