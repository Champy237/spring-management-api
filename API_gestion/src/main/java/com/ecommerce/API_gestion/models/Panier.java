package com.ecommerce.API_gestion.models;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "Panier")

public class Panier {

    public enum Status{

        ACTIF("actif"),
        VALIDE("valide"),
        ABANDONNE("abandonne");

        private final String label;

        
        Status(String label){

            this.label = label;
        }


        public String getLabel(){
            return label;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;

    private LocalDateTime date;
    
    @Enumerated(EnumType.STRING)
    private Status statut;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateurs_id")
    private Utilisateur utilisateurs;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "panier",orphanRemoval = true)
    private List<Detail_Panier> detail_paniers = new ArrayList<>();


    

    
}
