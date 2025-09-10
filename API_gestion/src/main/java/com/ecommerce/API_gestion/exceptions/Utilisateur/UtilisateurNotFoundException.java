package com.ecommerce.API_gestion.exceptions.Utilisateur;

import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;

public class UtilisateurNotFoundException extends BaseException {
    public UtilisateurNotFoundException(Integer id) {
        super("Utilisateur avec l'id " + id + " non trouvé",
              "UTILISATEUR_NOT_FOUND",
              HttpStatus.NOT_FOUND);
    }
}
