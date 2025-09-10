package com.ecommerce.API_gestion.exceptions.Produit;



import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;

public class InvalidQuantityException extends BaseException {

    public InvalidQuantityException(String message, String errorCode, HttpStatus httpStatus) {
        super("La quantite ne peut pas etre negative ", "INVALIOD_QUANTITY", httpStatus);
        
    }



    
}

