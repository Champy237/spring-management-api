package com.ecommerce.API_gestion.dto.detail_panier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail_PanierResponse {

    private Integer Id;

    private Integer quantite;

    private Integer produit_id;

    private Integer panier_id;
    
}
