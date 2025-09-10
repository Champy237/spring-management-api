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

import com.ecommerce.API_gestion.dto.categorie.CategorieRequest;
import com.ecommerce.API_gestion.dto.categorie.CategorieResponse;
import com.ecommerce.API_gestion.service.CategorieService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorie")
public class CategorieController {

        


@Autowired
    private CategorieService categorieService;

    @GetMapping("/list")
    public ResponseEntity<List<CategorieResponse>> getAllCategories() {
        List<CategorieResponse> categories = categorieService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/create")
    public ResponseEntity<CategorieResponse> createCategorie(@Valid @RequestBody CategorieRequest request) {
        CategorieResponse response = categorieService.creaCategorie(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategorieResponse> getCategorieById(@PathVariable Integer id) {
        CategorieResponse response = categorieService.getCategorieById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategorieResponse> updateCategorie(
            @PathVariable Integer id,
            @Valid @RequestBody CategorieRequest request) {

        CategorieResponse response = categorieService.updCategorie(id, request);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable Integer id) {
        categorieService.deleteCategorie(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
