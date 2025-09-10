package com.ecommerce.API_gestion.exceptions.Panier;

import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;

public class PanierNotFoundException extends BaseException {

        public PanierNotFoundException(Integer id) {
        super("Panier avec l'id " + id + " non trouvé",
              "PANIER_NOT_FOUND",
              HttpStatus.NOT_FOUND);
    }
    
}
