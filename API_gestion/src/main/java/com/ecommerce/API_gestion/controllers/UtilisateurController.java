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

import com.ecommerce.API_gestion.dto.utilisateur.UtilisateurRequest;
import com.ecommerce.API_gestion.dto.utilisateur.UtilisateurResponse;
import com.ecommerce.API_gestion.service.UtilisateurService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {
    


    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/create")
    public ResponseEntity<UtilisateurResponse> createUtilisateur(@Valid @RequestBody UtilisateurRequest request) {
        UtilisateurResponse utilisateurResponse = utilisateurService.creaUtilisateur(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UtilisateurResponse>> getAllUtilisateurs() {
        return ResponseEntity.ok(utilisateurService.getAllUtilisateurs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurResponse> getUtilisateurById(@PathVariable Integer id) {

        UtilisateurResponse response = utilisateurService.getUtilisateurById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurResponse> updateUtilisateur(@PathVariable Integer id,@Valid @RequestBody UtilisateurRequest utilisateurRequest) {

        UtilisateurResponse utilisateurResponse = utilisateurService.updUtilisateur(id, utilisateurRequest);
        return ResponseEntity.ok(utilisateurResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Integer id) {

        utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.noContent().build(); 
    }
    
}
