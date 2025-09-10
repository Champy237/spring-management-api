package com.ecommerce.API_gestion.exceptions.Utilisateur;



import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;
public class TelephoneAlreadyExsitException extends BaseException  {

    public TelephoneAlreadyExsitException(String Telephone){

            super("ce numero de telephone "+Telephone+ "apparteint deja a un Utilisateur","TELEPHONE_ALREADY_EXIST",HttpStatus.CONFLICT);
    }
    
}
