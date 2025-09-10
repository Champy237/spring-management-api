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

import com.ecommerce.API_gestion.dto.detail_commande.Detail_CommandeRequest;
import com.ecommerce.API_gestion.dto.detail_commande.Detail_CommandeResponse;
import com.ecommerce.API_gestion.service.Detail_CommandeService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/detail_commande")
public class Detail_CommandeController {
    @Autowired
    private Detail_CommandeService detail_CommandeService;


    @PostMapping("/create")
    public ResponseEntity< Detail_CommandeResponse> createDetail_Commande(@Valid @RequestBody Detail_CommandeRequest request) {

        Detail_CommandeResponse detail_CommandeResponse = detail_CommandeService.createDetailCommande(request);

        return ResponseEntity.ok(detail_CommandeResponse);

    }



    @GetMapping("/list")
    public  ResponseEntity< List<Detail_CommandeResponse>> getAllDetail_Commandes() {    

        return  ResponseEntity.ok(detail_CommandeService.getAllDetailCommandes()) ;
    }


    @GetMapping("/{id}")
    public ResponseEntity< Detail_CommandeResponse > getDetail_Commande(@Valid @PathVariable int id){


        Detail_CommandeResponse detail_CommandeResponse = detail_CommandeService.getDetailCommandeById(id);

        return ResponseEntity.ok(detail_CommandeResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity< Detail_CommandeResponse > updateDetail_commande(@Valid @PathVariable int id,@RequestBody Detail_CommandeRequest request ){

        Detail_CommandeResponse detail_CommandeResponse = detail_CommandeService.updateDetailCommande(id, request);

        return ResponseEntity.ok(detail_CommandeResponse);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategorie(@Valid @PathVariable Integer id) {
        
        String message = detail_CommandeService.deleteDetailCommande(id);

        
        if (message.contains("non trouvé")) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
            return ResponseEntity.ok(message);
    }


}
