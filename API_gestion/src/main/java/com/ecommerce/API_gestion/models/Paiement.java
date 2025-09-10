package com.ecommerce.API_gestion.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Entity
@Table(name = "Paiement")
public class Paiement {


    public enum Status{

        ECHOUE("echoue"),
        REUSSI("reussi"),
        EN_ATTENT("en attente");

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

    private Integer montant;

    private LocalDateTime createdAt;


    @Enumerated(EnumType.STRING)
    private Status statut;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "command_id")
    private Commande  commande;





    
    
}
