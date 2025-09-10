package com.ecommerce.API_gestion.dto.commande;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeResponse {

    private Integer Id;

    private LocalDateTime createdAt;

    private Integer montant_total;

    private String statut;

    private Integer utilisateur_id;
    
}
