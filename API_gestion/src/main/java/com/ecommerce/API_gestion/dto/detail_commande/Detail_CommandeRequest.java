package com.ecommerce.API_gestion.dto.detail_commande;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detail_CommandeRequest {


    @NotNull(message = "quantité obligatoire")
    @Min(value = 1, message = "la quantité doit être au moins 1")
    private Integer quantite;

    @NotNull(message = "le prix unitaire est obligatoire")
    @Min(value = 1, message = "le prix unitaire ne peut pas être négatif ou zéro")
    private Integer prix_unitaire;

    @NotNull(message = "le détail commande doit être attaché à une commande")
    private Integer commande_id;

    @NotNull(message = "le détail commande doit être associé à un produit")
    private Integer produit_id;
    
}
