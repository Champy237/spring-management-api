package com.ecommerce.API_gestion.dto.produit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduitResponse {

    private Integer Id;

    private String nom;

    private String description;

    private Integer prix;

    private Integer stock;

    private String image_url;

    private Integer categorie_id;
    
}
