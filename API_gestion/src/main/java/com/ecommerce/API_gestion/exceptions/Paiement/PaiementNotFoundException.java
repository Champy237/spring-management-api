package com.ecommerce.API_gestion.exceptions.Paiement;

import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;

public class PaiementNotFoundException extends BaseException {

    public PaiementNotFoundException(Integer id){

        super("Paiement avec l'id " +id+ " non trouve", "PAIEMENT_NOT_FOUND", HttpStatus.NOT_FOUND);
        
    }


    
}
