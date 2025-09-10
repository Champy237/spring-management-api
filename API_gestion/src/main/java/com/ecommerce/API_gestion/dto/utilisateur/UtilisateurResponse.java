package com.ecommerce.API_gestion.dto.utilisateur;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurResponse {

    private Integer Id;

    private String nom;

    private String prenom;

    private String email;

    private String telephone;

    private String adresse; 

    private LocalDateTime date_inscription;


    
}
