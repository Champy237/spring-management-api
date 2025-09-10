package com.ecommerce.API_gestion.dto.panier;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierResponse {

    private Integer Id;

    private LocalDateTime date;

    private String statut;

    private Integer utilisateur_id;
    
}
