package com.ecommerce.API_gestion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.API_gestion.dto.paiement.PaiementRequest;
import com.ecommerce.API_gestion.dto.paiement.PaiementResponse;
import com.ecommerce.API_gestion.exceptions.Commande.CommandeNotFoundException;
import com.ecommerce.API_gestion.exceptions.Paiement.PaiementNotFoundException;
import com.ecommerce.API_gestion.models.Commande;
import com.ecommerce.API_gestion.models.Paiement;
import com.ecommerce.API_gestion.repository.CommandeRepository;
import com.ecommerce.API_gestion.repository.PaiementRepository;
import com.ecommerce.API_gestion.utils.Utils;




@Service
public class PaiementService {

    @Autowired
    PaiementRepository paiementRepository;

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    Utils utils;


    // Création d’un détail d'un paiment

    public PaiementResponse createPaiemnt(PaiementRequest request){

        Paiement paiement = new Paiement();

        Commande commande = new Commande();


        paiement.setId(request.getId());

        paiement.setStatut(Paiement.Status.valueOf(request.getStatut().toUpperCase()));


        paiement.setMontant(request.getMontant());

        paiement.setCreatedAt(request.getCreatedAt());

        commande = commandeRepository.findById(request.getCommande_id()).orElseThrow(() -> new CommandeNotFoundException(request.getCommande_id()));
        paiement.setCommande(commande);

        Paiement saved = paiementRepository.save(paiement);

        return utils.convPaiementResponse(saved);


    }


    // Liste de tous les  paiement

    public List<PaiementResponse> getAllpPaiement(){

        List<Paiement> details = paiementRepository.findAll();
        List<PaiementResponse> responses = new ArrayList<>();

        for (Paiement d: details){
            responses.add(utils.convPaiementResponse(d));
        }
        
        return responses;
    }


    



    //  Recherche d’un Paiement par ID
    public PaiementResponse gePaiementById(Integer id) {

        Paiement paiement = paiementRepository.findById(id).orElseThrow(() -> new PaiementNotFoundException(id));

       return utils.convPaiementResponse(paiement);
    }


    // Mise à jour d’un détail d'un paiement
     
    public PaiementResponse updatePaiement(Integer id, PaiementRequest request) {

        Paiement paiement = paiementRepository.findById(id).orElseThrow(() -> new PaiementNotFoundException(id));

        paiement.setId(request.getId());

        paiement.setStatut(Paiement.Status.valueOf(request.getStatut().toUpperCase()));

        paiement.setMontant(request.getMontant());

        paiement.setCreatedAt(request.getCreatedAt());

        Commande commande = commandeRepository.findById(request.getCommande_id()).orElseThrow(() -> new CommandeNotFoundException(request.getCommande_id()));
        paiement.setCommande(commande);

        Paiement update = paiementRepository.save(paiement);

        return utils.convPaiementResponse(update);

    }


    // Suppression d’un détail de paiement
    public String delectePaiement(Integer id) {
        if (!paiementRepository.existsById(id)) {
             return "paiement avec l'id " + id + " introuvable.";
        }
        paiementRepository.deleteById(id);
        return "paiement avec l'id " + id + " supprimé avec succès.";
    }
    

    
}
