package com.ecommerce.API_gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;




public interface UtilisateurRepository  extends JpaRepository <com.ecommerce.API_gestion.models.Utilisateur,Integer>{

    boolean existsByEmail(String email);


    
}
