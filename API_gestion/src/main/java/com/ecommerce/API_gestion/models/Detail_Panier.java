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

@Data

@Entity
@Table(name = "Detail_panier")
public class Detail_Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;

    private Integer quantite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Produit_id")
    private Produit produit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Panier_id")
    private Panier panier;

    
}
