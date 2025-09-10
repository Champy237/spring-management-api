package com.ecommerce.API_gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository < com.ecommerce.API_gestion.models.Commande, Integer > {
    
}
