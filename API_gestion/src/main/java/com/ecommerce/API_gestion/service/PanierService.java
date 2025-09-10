package com.ecommerce.API_gestion.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.API_gestion.dto.panier.PanierRequest;
import com.ecommerce.API_gestion.dto.panier.PanierResponse;
import com.ecommerce.API_gestion.exceptions.Panier.PanierNotFoundException;
import com.ecommerce.API_gestion.exceptions.Utilisateur.UtilisateurNotFoundException;
import com.ecommerce.API_gestion.models.Panier;
import com.ecommerce.API_gestion.models.Utilisateur;
import com.ecommerce.API_gestion.repository.PanierRepository;
import com.ecommerce.API_gestion.repository.UtilisateurRepository;
import com.ecommerce.API_gestion.utils.Utils;



@Service
public class PanierService {


    @Autowired
    PanierRepository panierRepository;

    @Autowired 
    UtilisateurRepository utilisateurRepository;

    @Autowired
    Utils utils;



    //creation d'un panier 
    public PanierResponse creatPanier(PanierRequest request){

        Panier panier = new Panier();

        Utilisateur utilisateur = new Utilisateur();

        panier.setDate(LocalDateTime.now());
        
        panier.setStatut(Panier.Status.VALIDE);        

        utilisateur = utilisateurRepository.findById(request.getUtilisateur_id()).orElseThrow(() -> new UtilisateurNotFoundException(request.getUtilisateur_id()));
        panier.setUtilisateurs(utilisateur);

        Panier saved = panierRepository.save(panier);

        return utils.convPanierResponse(saved);


    }


    //List des panier 
    public List<PanierResponse> getAllpPanier(){

        List<Panier> paniers = panierRepository.findAll();
        List<PanierResponse> responses = new ArrayList<>();

        for (Panier d: paniers){
            responses.add(utils.convPanierResponse(d));
        }
        
        return responses;
    }





    //  Recherche d’un Paiement par ID
    public PanierResponse gePanierById(Integer id) {

        Panier panier = panierRepository.findById(id).orElseThrow(() -> new PanierNotFoundException(id));

       return utils.convPanierResponse(panier);
    }

    //MODfication su panier 

    public PanierResponse updatePanier(Integer id, PanierRequest request) {

        Panier panier = panierRepository.findById(id).orElseThrow(() -> new PanierNotFoundException(id));

        panier.setStatut(Panier.Status.valueOf(request.getStatut().toUpperCase()));

        Utilisateur  utilisateur = utilisateurRepository.findById(request.getUtilisateur_id()).orElseThrow(() -> new UtilisateurNotFoundException(request.getUtilisateur_id()));
        panier.setUtilisateurs(utilisateur);

        Panier updated = panierRepository.save(panier);

        return utils.convPanierResponse(updated);

    }

    //supression du panier 

    public String delectePanier(Integer id) {
        if (!panierRepository.existsById(id)) {
             return "panier avec l'id " + id + " introuvable.";
        }
        panierRepository.deleteById(id);
        return "panier avec l'id " + id + " supprimé avec succès.";
    }


    
}
