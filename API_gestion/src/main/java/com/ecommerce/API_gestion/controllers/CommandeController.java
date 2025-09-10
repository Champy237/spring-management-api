package com.ecommerce.API_gestion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.API_gestion.dto.commande.CommandeRequest;
import com.ecommerce.API_gestion.dto.commande.CommandeResponse;
import com.ecommerce.API_gestion.service.CommandeService;

@RestController
@RequestMapping("/api/commande")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @PostMapping("/create")
    public ResponseEntity<CommandeResponse> createCommande(@RequestBody CommandeRequest request) {
        CommandeResponse response = commandeService.creaCommande(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CommandeResponse>> getAllCommandes() {
        return ResponseEntity.ok(commandeService.getAllCommandes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeResponse> getCommandeById(@PathVariable Integer id) {
        return ResponseEntity.ok(commandeService.getCommandeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandeResponse> updateCommande(@PathVariable Integer id, @RequestBody CommandeRequest request) {
        return ResponseEntity.ok(commandeService.updCommande(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCommande(@PathVariable Integer id) {
        commandeService.deleteCommande(id);
        return ResponseEntity.ok("Commande supprimée avec succès.");
    }
}
