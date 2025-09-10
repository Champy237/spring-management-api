package com.ecommerce.API_gestion.utils;

import org.springframework.stereotype.Component;

import com.ecommerce.API_gestion.dto.categorie.CategorieResponse;
import com.ecommerce.API_gestion.dto.commande.CommandeResponse;
import com.ecommerce.API_gestion.dto.detail_commande.Detail_CommandeResponse;
import com.ecommerce.API_gestion.dto.detail_panier.Detail_PanierResponse;
import com.ecommerce.API_gestion.dto.paiement.PaiementResponse;
import com.ecommerce.API_gestion.dto.panier.PanierResponse;
import com.ecommerce.API_gestion.dto.produit.ProduitResponse;
import com.ecommerce.API_gestion.dto.utilisateur.UtilisateurResponse;
import com.ecommerce.API_gestion.models.Categorie;
import com.ecommerce.API_gestion.models.Commande;
import com.ecommerce.API_gestion.models.Detail_Commande;
import com.ecommerce.API_gestion.models.Detail_Panier;
import com.ecommerce.API_gestion.models.Paiement;
import com.ecommerce.API_gestion.models.Panier;
import com.ecommerce.API_gestion.models.Produit;
import com.ecommerce.API_gestion.models.Utilisateur;


@Component
public class Utils {
    


    public UtilisateurResponse convertUtilisateurResponse(Utilisateur utilisateur){

        return new UtilisateurResponse(

            utilisateur.getId(),
            utilisateur.getNom(),
            utilisateur.getPrenom(),
            utilisateur.getEmail(),
            utilisateur.getTelephone(),
            utilisateur.getAdresse(),
            utilisateur.getDate_inscription()
        
        );

    }

    public ProduitResponse convProduitResponse(Produit produit){

        return new ProduitResponse(

            produit.getId(),
            produit.getNom(),
            produit.getDescription(),
            produit.getPrix(),
            produit.getStock(),
            produit.getImage_url(),
            produit.getCategorie().getId()

        );
    }

    public PanierResponse convPanierResponse(Panier panier){

        return new PanierResponse(

            panier.getId(),
            panier.getDate(),
            panier.getStatut().getLabel(),
            panier.getUtilisateurs().getId()


        );

    }

    public  PaiementResponse convPaiementResponse(Paiement paiement){


        return new PaiementResponse(

            paiement.getId(),
            paiement.getStatut().getLabel(),
            paiement.getMontant(),
            paiement.getCreatedAt(),
            paiement.getCommande().getId()

        );

    }

    public Detail_PanierResponse convDetail_PanierResponse(Detail_Panier detail_Panier){

        return new Detail_PanierResponse(

            detail_Panier.getId(),
            detail_Panier.getQuantite(),
            detail_Panier.getProduit().getId(),
            detail_Panier.getPanier().getId()

        );

    }

    public Detail_CommandeResponse convDetail_CommandeResponse(Detail_Commande detail_Commande){

        return new Detail_CommandeResponse(

            detail_Commande.getId(),
            detail_Commande.getQuantite(),
            detail_Commande.getPrix_unitaire(),
            detail_Commande.getCommande().getId(),
            detail_Commande.getProduit().getId()

        );

    }

    public CommandeResponse convCommandeResponse(Commande commande){

        return  new CommandeResponse(

            commande.getId(),
            commande.getCreatedAt(),
            commande.getMontant_total(),
            commande.getStatut().getLabel(),
            commande.getUtilisateurs().getId()


        );

    }

    public CategorieResponse convCategorieResponse(Categorie categorie){

        return new CategorieResponse(

            categorie.getId(),
            categorie.getNom(),
            categorie.getDescription()

        );

    }


}
