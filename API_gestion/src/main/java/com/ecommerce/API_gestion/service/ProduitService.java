package com.ecommerce.API_gestion.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.API_gestion.dto.produit.ProduitRequest;
import com.ecommerce.API_gestion.dto.produit.ProduitResponse;
import com.ecommerce.API_gestion.exceptions.Categorie.CategorieNotFoundException;
import com.ecommerce.API_gestion.exceptions.Produit.ProduitNotFoundException;
import com.ecommerce.API_gestion.models.Categorie;
import com.ecommerce.API_gestion.models.Produit;
import com.ecommerce.API_gestion.repository.CategorieRepository;
import com.ecommerce.API_gestion.repository.ProduitRepository;
import com.ecommerce.API_gestion.utils.Utils;


@Service
public class ProduitService {

 @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private Utils utils;

    // Création d’un produit
    public ProduitResponse createProduit(ProduitRequest request) {

        Produit produit = new Produit();

        produit.setNom(request.getNom());
        produit.setDescription(request.getDescription());
        produit.setPrix(request.getPrix());
        produit.setStock(request.getStock());
        produit.setImage_url(request.getImage_url());

        Categorie categorie = categorieRepository.findById(request.getCategorie_id()).orElseThrow(() -> new CategorieNotFoundException(request.getCategorie_id())); 
        produit.setCategorie(categorie);

        Produit saved = produitRepository.save(produit);

        return utils.convProduitResponse(saved);
    }

    // Liste des produits
    public List<ProduitResponse> getAllProduits() {
        List<Produit> produits = produitRepository.findAll();
        List<ProduitResponse> responses = new ArrayList<>();

        for (Produit produit : produits) {
            responses.add(utils.convProduitResponse(produit));
        }

        return responses;
    }

    //Recherche d’un produit par son ID
    public ProduitResponse getProduitById(Integer id) {
        Produit produit = produitRepository.findById(id).orElseThrow(() -> new ProduitNotFoundException(id));
        return utils.convProduitResponse(produit);
    }

    //  Modification d’un produit
    public ProduitResponse updateProduitById(Integer id, ProduitRequest request) {

        Produit produit = produitRepository.findById(id).orElseThrow(() -> new ProduitNotFoundException(id));

        produit.setNom(request.getNom());
        produit.setDescription(request.getDescription());
        produit.setPrix(request.getPrix());
        produit.setStock(request.getStock());
        produit.setImage_url(request.getImage_url());

        Categorie categorie = categorieRepository.findById(request.getCategorie_id())
                .orElseThrow(() -> new CategorieNotFoundException(request.getCategorie_id())); 
        produit.setCategorie(categorie);

        Produit updated = produitRepository.save(produit);

        return utils.convProduitResponse(updated);
    }

    // Suppression d’un produit
    public String deleteProduitById(Integer id) {
        if (produitRepository.existsById(id)) {
            produitRepository.deleteById(id);
            return "Produit avec l'id " + id + " supprimé avec succès.";
        } else {
            return "Produit avec l'id " + id + " non trouvé.";
        }
    }




}
