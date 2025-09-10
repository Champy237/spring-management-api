package com.ecommerce.API_gestion.dto.paiement;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaiementRequest {

    private Integer Id;

    private String statut;

    @Min(value = 500, message = "Le paiement ne doit pas être inférieur à 500")
    private Integer montant;

    private LocalDateTime createdAt;

    @NotNull(message = "L'ID de la commande est obligatoire")
    private Integer commande_id;
}
