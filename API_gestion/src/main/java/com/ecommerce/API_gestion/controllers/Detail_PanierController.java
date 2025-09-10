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

import com.ecommerce.API_gestion.dto.detail_panier.Detail_PanierResponse;
import com.ecommerce.API_gestion.dto.detail_panier.Detail_panierRequest;
import com.ecommerce.API_gestion.service.Detail_PanierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/detail_paniers")
public class Detail_PanierController {




    @Autowired
    private Detail_PanierService detailPanierService;

    @PostMapping("/create")
    public ResponseEntity<Detail_PanierResponse> createDetailPanier(@Valid @RequestBody Detail_panierRequest request) {
        Detail_PanierResponse detailResponse = detailPanierService.createDetailPanier(request);
        return ResponseEntity.ok(detailResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Detail_PanierResponse>> getAllDetailPaniers() {
        return ResponseEntity.ok(detailPanierService.getAllDetailPanier());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detail_PanierResponse> getDetailPanierById(@Valid @PathVariable int id) {

        Detail_PanierResponse response = detailPanierService.getDetailPanierById(id);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Detail_PanierResponse> updateDetailPanier(@Valid @PathVariable int id,@RequestBody Detail_panierRequest request) {
        Detail_PanierResponse detailResponse = detailPanierService.updateDetailPanier(id, request);
        return ResponseEntity.ok(detailResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDetailPanier(@Valid @PathVariable Integer id) {
        String message = detailPanierService.deleteDetailPanier(id);

        if (message.contains("non trouvé")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        return ResponseEntity.ok(message);
    }
    
}
