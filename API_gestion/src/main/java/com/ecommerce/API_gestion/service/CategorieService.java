package com.ecommerce.API_gestion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.API_gestion.dto.categorie.CategorieRequest;
import com.ecommerce.API_gestion.dto.categorie.CategorieResponse;
import com.ecommerce.API_gestion.exceptions.Categorie.CategorieNotFoundException;
import com.ecommerce.API_gestion.models.Categorie;
import com.ecommerce.API_gestion.repository.CategorieRepository;
import com.ecommerce.API_gestion.utils.Utils;

@Service
public class CategorieService {


     @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private Utils utils;

    // Liste toutes les catégories
    public List<CategorieResponse> getAllCategories() {
        List<Categorie> categoriesList = categorieRepository.findAll();
        List<CategorieResponse> responses = new ArrayList<>();

        for (Categorie categorie : categoriesList) {
            responses.add(utils.convCategorieResponse(categorie));
        }

        return responses;
    }

    // Création d'une catégorie
    public CategorieResponse creaCategorie(CategorieRequest request) {
        Categorie categorie = new Categorie();

        categorie.setNom(request.getNom());
        categorie.setDescription(request.getDescription());

        Categorie saved = categorieRepository.save(categorie);

        return utils.convCategorieResponse(saved);
    }

    // Recherche d'une catégorie par id
    public CategorieResponse getCategorieById(Integer id) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new CategorieNotFoundException(id));
        return utils.convCategorieResponse(categorie);
    }

    // Modification d'une catégorie par id
    public CategorieResponse updCategorie(Integer id, CategorieRequest categorieRequest) {
        Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new CategorieNotFoundException(id));

        categorie.setNom(categorieRequest.getNom());
        categorie.setDescription(categorieRequest.getDescription());

        Categorie updated = categorieRepository.save(categorie);

        return utils.convCategorieResponse(updated);
    }

    // Suppression d'une catégorie par id
    public void deleteCategorie(Integer id) {
        Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new CategorieNotFoundException(id));
        categorieRepository.delete(categorie);
    }

    
}
