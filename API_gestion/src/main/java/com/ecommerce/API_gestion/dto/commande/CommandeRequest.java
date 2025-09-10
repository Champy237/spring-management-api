package com.ecommerce.API_gestion.dto.commande;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeRequest {
        
    private Integer Id;

    private LocalDateTime createdAt;

    @NotNull(message = "le montant est obligatoire")
    @Min(value = 1, message = "le montant ne peut pas être négatif ou zéro")
    private Integer montant_total;

    private String statut;

    @NotNull(message = "une commande doit être associée à un utilisateur")
    private Integer utilisateur_id;
    
}
