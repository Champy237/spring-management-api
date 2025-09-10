package com.ecommerce.API_gestion.dto.paiement;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaiementResponse {

    private Integer Id;

    private String statut;

    private Integer motant;

    private LocalDateTime createdAt;

    private Integer commande_id;

    
}
