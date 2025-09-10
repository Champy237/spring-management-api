package com.ecommerce.API_gestion.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data


@Entity
@Table(name = "Utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;

    private String nom;

    private String prenom;

    private String email;

    private String mot_de_passe;

    private String telephone;

    private String adresse;

    private LocalDateTime date_inscription;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateurs",orphanRemoval = true)
    private List<Panier> panier = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "utilisateurs",orphanRemoval = true)
    private List<Commande> commande = new ArrayList<>();



    


    
}
