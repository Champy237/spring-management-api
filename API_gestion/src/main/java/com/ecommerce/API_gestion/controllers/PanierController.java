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

import com.ecommerce.API_gestion.dto.panier.PanierRequest;
import com.ecommerce.API_gestion.dto.panier.PanierResponse;
import com.ecommerce.API_gestion.service.PanierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/paniers")
public class PanierController {



    @Autowired
    private PanierService panierService;


    @PostMapping("/create")
    public ResponseEntity<PanierResponse> createPanier(@Valid @RequestBody PanierRequest request) {
        PanierResponse panierResponse = panierService.creatPanier(request);
        return ResponseEntity.ok(panierResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<List<PanierResponse>> getAllPaniers() {
        return ResponseEntity.ok(panierService.getAllpPanier());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanierResponse> getPanierById(@Valid @PathVariable int id) {

        PanierResponse response = panierService.gePanierById(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PanierResponse> updatePanier(@Valid @PathVariable int id,@RequestBody PanierRequest request) {
        PanierResponse panierResponse = panierService.updatePanier(id, request);
        return ResponseEntity.ok(panierResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePanier(@Valid @PathVariable Integer id) {
        String message = panierService.delectePanier(id);

        if (message.contains("non trouvé")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        return ResponseEntity.ok(message);
    }
    
}
