package com.ecommerce.API_gestion.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity

@Data
@Table(name= "Detail_Commande")
public class Detail_Commande {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Integer Id;

    private Integer quantite;

    private Integer prix_unitaire;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Commande_id")
    private Commande commande;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Produit_id")
    private Produit produit;


    
}
