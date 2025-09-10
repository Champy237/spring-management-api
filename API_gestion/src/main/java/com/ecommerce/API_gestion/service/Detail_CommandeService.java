package com.ecommerce.API_gestion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.API_gestion.dto.detail_commande.Detail_CommandeRequest;
import com.ecommerce.API_gestion.dto.detail_commande.Detail_CommandeResponse;
import com.ecommerce.API_gestion.exceptions.Commande.CommandeNotFoundException;
import com.ecommerce.API_gestion.exceptions.Detail_Commande.DetailCommandeNotFoundException;
import com.ecommerce.API_gestion.exceptions.Produit.ProduitNotFoundException;
import com.ecommerce.API_gestion.models.Commande;
import com.ecommerce.API_gestion.models.Detail_Commande;
import com.ecommerce.API_gestion.models.Produit;
import com.ecommerce.API_gestion.repository.CommandeRepository;
import com.ecommerce.API_gestion.repository.Detail_CommandeRepository;
import com.ecommerce.API_gestion.repository.ProduitRepository;
import com.ecommerce.API_gestion.utils.Utils;





@Service
public class Detail_CommandeService {

    @Autowired
    Detail_CommandeRepository detail_CommandeRepository;

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    ProduitRepository produitRepository;


    @Autowired
    private Utils utils;

    // Création d’un détail de commande
    public Detail_CommandeResponse createDetailCommande(Detail_CommandeRequest request) {

        Detail_Commande detailCommande = new Detail_Commande();

        Commande commande =  new Commande();

        Produit produit = new Produit();

        detailCommande.setQuantite(request.getQuantite());


        detailCommande.setPrix_unitaire(request.getPrix_unitaire());

        commande = commandeRepository.findById(request.getCommande_id()).orElseThrow(() -> new CommandeNotFoundException(request.getCommande_id()));
        detailCommande.setCommande(commande);

        produit = produitRepository.findById(request.getProduit_id()).orElseThrow(() ->new ProduitNotFoundException(request.getProduit_id()));
        detailCommande.setProduit(produit);

        Detail_Commande saved = detail_CommandeRepository.save(detailCommande);

        return utils.convDetail_CommandeResponse(saved);


    }

    // Liste de tous les détails de commande
    public List<Detail_CommandeResponse> getAllDetailCommandes() {
        List<Detail_Commande> details = detail_CommandeRepository.findAll();
        List<Detail_CommandeResponse> responses = new ArrayList<>();

        for (Detail_Commande d : details) {
            responses.add(utils.convDetail_CommandeResponse(d));
        }

        return responses;
    }



    //  Recherche d’un détail par ID
    public Detail_CommandeResponse getDetailCommandeById(Integer id) {

        Detail_Commande detail_Commande = detail_CommandeRepository.findById(id).orElseThrow(() -> new DetailCommandeNotFoundException(id) );
        
        return utils.convDetail_CommandeResponse(detail_Commande);
    }

    // Mise à jour d’un détail de commande
    public Detail_CommandeResponse updateDetailCommande(Integer id, Detail_CommandeRequest request) {

        Detail_Commande detail = detail_CommandeRepository.findById(id).orElseThrow(() -> new DetailCommandeNotFoundException(id));

        detail.setQuantite(request.getQuantite());
        detail.setPrix_unitaire(request.getPrix_unitaire());

        Commande commande = commandeRepository.findById(request.getCommande_id()).orElseThrow(() -> new CommandeNotFoundException(request.getCommande_id()));
        detail.setCommande(commande);

        Produit produit =produitRepository.findById(request.getProduit_id()).orElseThrow(() -> new ProduitNotFoundException(request.getProduit_id()));
        detail.setProduit(produit);

        Detail_Commande updated = detail_CommandeRepository.save(detail);

        return utils.convDetail_CommandeResponse(updated);
    }




    // Suppression d’un détail de commande
    public String deleteDetailCommande(Integer id) {
        if (!detail_CommandeRepository.existsById(id)) {
            return "Detail_Commande avec l'id " + id + " introuvable.";
        }
        detail_CommandeRepository.deleteById(id);
        return "Detail_Commande avec l'id " + id + " supprimé avec succès.";
    }
    
    
}
