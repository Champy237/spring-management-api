package com.ecommerce.API_gestion.dto.panier;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierRequest {



    @NotBlank(message = "Le statut est obligatoire")
    private String statut;

    @NotNull(message = "Le panier doit être associé à un utilisateur")
    private Integer utilisateur_id;
}
