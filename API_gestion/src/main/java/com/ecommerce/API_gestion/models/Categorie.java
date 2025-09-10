package com.ecommerce.API_gestion.models;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;


@Data

@Entity
@Table(name = "Categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;

    private String nom;

    private String description;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie",orphanRemoval = true)
    private List<Produit>  produits = new ArrayList<>();
    
    
}
