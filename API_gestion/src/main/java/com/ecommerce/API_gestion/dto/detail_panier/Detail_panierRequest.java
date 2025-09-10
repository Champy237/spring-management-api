package com.ecommerce.API_gestion.dto.detail_panier;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detail_panierRequest {

    @NotNull(message = "La quantité est obligatoire")
    @Min(value = 1, message = "La quantité doit être au moins 1")
    private Integer quantite;

    @NotNull(message = "Le détail panier doit être associé à un produit")
    private Integer produit_id;

    @NotNull(message = "Le détail panier doit être associé à un panier")
    private Integer panier_id;
    
}
