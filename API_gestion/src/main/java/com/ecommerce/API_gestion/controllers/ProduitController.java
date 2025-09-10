package com.ecommerce.API_gestion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.API_gestion.dto.produit.ProduitRequest;
import com.ecommerce.API_gestion.dto.produit.ProduitResponse;
import com.ecommerce.API_gestion.service.ProduitService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    


    @Autowired
    private ProduitService produitService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduit(@Valid @RequestBody ProduitRequest request) {
        ProduitResponse produitResponse = produitService.createProduit(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(produitResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProduitResponse>> getAllProduits() {
        return ResponseEntity.ok(produitService.getAllProduits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitResponse> getProduitById(@Valid @PathVariable int id) {
        ProduitResponse  response = produitService.getProduitById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProduitResponse> updateProduit(@Valid @PathVariable int id,
                                                         @RequestBody ProduitRequest request) {
        ProduitResponse produitResponse = produitService.updateProduitById(id, request);
        return ResponseEntity.ok(produitResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduit(@Valid @PathVariable Integer id) {
        String message = produitService.deleteProduitById(id);

        if (message.contains("non trouvé")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        return ResponseEntity.ok(message);
    }
}
