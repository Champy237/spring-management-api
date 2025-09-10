package com.ecommerce.API_gestion.exceptions.Produit;

import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;

public class ProduitNotFoundException extends BaseException{

    public ProduitNotFoundException(Integer id){


        super("Prosuit avec l'id " + id +  " non trouve" , "PRODUIT_NOT_FOUND",HttpStatus.NOT_FOUND );
    }





    
}
//public class UtilisateurNotFoundException extends BaseException {
//     public UtilisateurNotFoundException(Integer id) {
//         super("Utilisateur avec l'id " + id + " non trouvé",
//               "UTILISATEUR_NOT_FOUND",
//               HttpStatus.NOT_FOUND);
//     }
// }
