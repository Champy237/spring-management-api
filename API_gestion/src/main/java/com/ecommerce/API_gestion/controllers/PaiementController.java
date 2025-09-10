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

import com.ecommerce.API_gestion.dto.paiement.PaiementRequest;
import com.ecommerce.API_gestion.dto.paiement.PaiementResponse;
import com.ecommerce.API_gestion.service.PaiementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {
    



    @Autowired
    private PaiementService paiementService;


    @PostMapping("/create")
    public ResponseEntity<PaiementResponse> createPaiement(@Valid @RequestBody PaiementRequest request) {
        PaiementResponse paiementResponse = paiementService.createPaiemnt(request);
        return ResponseEntity.ok(paiementResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<List<PaiementResponse>> getAllPaiements() {
        return ResponseEntity.ok(paiementService.getAllpPaiement());
    }


    @GetMapping("/{id}")
    public ResponseEntity<PaiementResponse> getPaiementById(@Valid @PathVariable int id) {
        try {
            PaiementResponse response = paiementService.gePaiementById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<PaiementResponse> updatePaiement(@Valid @PathVariable int id, @RequestBody PaiementRequest request) {
        PaiementResponse paiementResponse = paiementService.updatePaiement(id, request);
        return ResponseEntity.ok(paiementResponse);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaiement(@Valid @PathVariable Integer id) {
        String message = paiementService.delectePaiement(id);

        if (message.contains("non trouvé")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        return ResponseEntity.ok(message);
    }
}
