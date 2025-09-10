package com.ecommerce.API_gestion.exceptions.Categorie;

import org.springframework.http.HttpStatus;

import com.ecommerce.API_gestion.exceptions.BaseException;

public class CategorieNotFoundException extends BaseException  {

        public CategorieNotFoundException(Integer id) {
        super("Catégorie avec l'id " + id + " non trouvée",
              "CATEGORIE_NOT_FOUND",
              HttpStatus.NOT_FOUND);
    }
    
}
