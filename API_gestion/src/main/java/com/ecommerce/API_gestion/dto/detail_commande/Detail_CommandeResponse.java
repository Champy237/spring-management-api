package com.ecommerce.API_gestion.dto.detail_commande;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail_CommandeResponse {

    private Integer Id;

    private Integer quantite;

    private Integer prix_unitaire;

    private Integer commande_id;

    private Integer produit_id;
    
}
