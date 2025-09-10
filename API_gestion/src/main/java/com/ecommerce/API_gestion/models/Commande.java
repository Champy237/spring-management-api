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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity

@Data
@Table(name="Commande")
public class Commande {

    public enum Status{

        EN_ATTENT("en_attente"),
        PAYE("paye"),
        LIVRE("livre"),
        ANNULE("annule");

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

    private LocalDateTime createdAt;

    private Integer montant_total;

    @Enumerated(EnumType.STRING)
    private Status statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateurs_id")
    private Utilisateur utilisateurs;

    @OneToOne(mappedBy = "commande",cascade = CascadeType.ALL)
    private Paiement paiement;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande",orphanRemoval = true)
    private List<Detail_Commande> detail_Commandes = new ArrayList<>();
    
    
    
}
