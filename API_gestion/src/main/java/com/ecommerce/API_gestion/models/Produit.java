package com.ecommerce.API_gestion.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Produit")

public class Produit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;

    private String nom;

    private String description;

    private Integer prix;

    private Integer stock;

    private String image_url;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit",orphanRemoval = true)
    private List<Detail_Commande> detail_Commandes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Categorie_id")
    private Categorie categorie;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit",orphanRemoval = true)
    private List<Detail_Panier> detail_panier = new ArrayList<>();



}
