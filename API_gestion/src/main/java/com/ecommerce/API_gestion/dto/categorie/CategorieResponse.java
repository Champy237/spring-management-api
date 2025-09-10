package com.ecommerce.API_gestion.dto.categorie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorieResponse {

    private Integer Id;

    private String nom;

    private String description;
    
}
