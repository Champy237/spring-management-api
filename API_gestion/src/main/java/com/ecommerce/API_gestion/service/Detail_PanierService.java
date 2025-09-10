package com.ecommerce.API_gestion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.API_gestion.dto.detail_panier.Detail_PanierResponse;
import com.ecommerce.API_gestion.dto.detail_panier.Detail_panierRequest;
import com.ecommerce.API_gestion.models.Detail_Panier;
import com.ecommerce.API_gestion.models.Panier;
import com.ecommerce.API_gestion.models.Produit;
import com.ecommerce.API_gestion.repository.Detail_PanierRepository;
import com.ecommerce.API_gestion.repository.PanierRepository;
import com.ecommerce.API_gestion.repository.ProduitRepository;
import com.ecommerce.API_gestion.utils.Utils;

@Service
public class Detail_PanierService {


    @Autowired
    Detail_PanierRepository detail_PanierRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    PanierRepository panierRepository;

    @Autowired
    Utils utils;



    // Création d’un détail de panier

    public Detail_PanierResponse createDetailPanier(Detail_panierRequest request){

        Detail_Panier detail_Panier = new Detail_Panier();

        Panier panier = new Panier();

        Produit produit = new Produit();


        detail_Panier.setId(request.getPanier_id());
        detail_Panier.setQuantite(request.getQuantite());

        panier = panierRepository.findById(request.getPanier_id()).orElseThrow(() -> new RuntimeException("panier avec id " + request.getPanier_id()  + " introuvable"));
        detail_Panier.setPanier(panier);

        produit = produitRepository.findById(request.getProduit_id()).orElseThrow(() -> new RuntimeException("produit avec id " + request.getProduit_id() + " introuvable"));
        detail_Panier.setProduit(produit);

        Detail_Panier saved = detail_PanierRepository.save(detail_Panier);

        return utils.convDetail_PanierResponse(saved);


    }


    // Liste de tous les détails de panier
    public List<Detail_PanierResponse> getAllDetailPanier() {
        List<Detail_Panier> details = detail_PanierRepository.findAll();
        List<Detail_PanierResponse> responses = new ArrayList<>();

        for (Detail_Panier d : details) {
            responses.add(utils.convDetail_PanierResponse(d));
        }

        return responses;
    }



    //  Recherche d’un détail par ID
    public Detail_PanierResponse getDetailPanierById(Integer id) {

        Detail_Panier detail = detail_PanierRepository.findById(id).orElseThrow(() -> new RuntimeException("Detail_Panier avec id " + id + " introuvable"));

        return utils.convDetail_PanierResponse(detail);
    }

    // Mise à jour d’un détail d'un panier
    public Detail_PanierResponse updateDetailPanier(Integer id, Detail_panierRequest request) {

        Detail_Panier detail = detail_PanierRepository.findById(id).orElseThrow(() -> new RuntimeException("Detail_Panier avec id " + id + " introuvable"));

        detail.setQuantite(request.getQuantite());


        Panier panier = panierRepository.findById(request.getPanier_id()).orElseThrow(() -> new RuntimeException("panier avec id " + request.getPanier_id()  + " introuvable"));;
        detail.setPanier(panier);

        Produit produit = produitRepository.findById(request.getProduit_id()).orElseThrow(() -> new RuntimeException("produit avec id " + request.getProduit_id() + " introuvable"));;
        detail.setProduit(produit);


        Detail_Panier updated = detail_PanierRepository.save(detail);

        return utils.convDetail_PanierResponse(updated);

    }


    // Suppression d’un détail de panier
    public String deleteDetailPanier(Integer id) {
         if (!detail_PanierRepository.existsById(id)) {
             return "Detail_Panier avec l'id " + id + " introuvable.";
        }
        detail_PanierRepository.deleteById(id);
         return "Detail_Panier avec l'id " + id + " supprimé avec succès.";
        }
    
}
