package com.ecommerce.API_gestion.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.API_gestion.dto.utilisateur.UtilisateurRequest;
import com.ecommerce.API_gestion.dto.utilisateur.UtilisateurResponse;
import com.ecommerce.API_gestion.exceptions.Utilisateur.EmailAlreadyExistException;
import com.ecommerce.API_gestion.exceptions.Utilisateur.InvalidPasswordException;
import com.ecommerce.API_gestion.exceptions.Utilisateur.UtilisateurNotFoundException;
import com.ecommerce.API_gestion.models.Utilisateur;
import com.ecommerce.API_gestion.repository.UtilisateurRepository;
import com.ecommerce.API_gestion.utils.Utils;

@Service
public class UtilisateurService {
    
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private Utils utils;


    //List les utilisateur
    public List<UtilisateurResponse> getAllUtilisateurs() {
        List<Utilisateur> utilisateursList = utilisateurRepository.findAll();
        List<UtilisateurResponse> responses = new ArrayList<>();

        for (Utilisateur utilisateur : utilisateursList) {
            responses.add(utils.convertUtilisateurResponse(utilisateur));
        }

        return responses;
    }


    //creation d'un utilisateur
    public UtilisateurResponse creaUtilisateur(UtilisateurRequest request) {


        if (utilisateurRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistException(request.getEmail());
        }

        if (request.getMot_de_passe().length() < 6) {
            throw new InvalidPasswordException();
        }
        

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setNom(request.getNom());
        utilisateur.setPrenom(request.getPrenom());

        

        utilisateur.setEmail(request.getEmail());
        utilisateur.setMot_de_passe(request.getMot_de_passe());
        utilisateur.setTelephone(request.getTelephone());
        utilisateur.setAdresse(request.getAdresse());

        if (request.getDate_inscription() != null) {
            utilisateur.setDate_inscription(request.getDate_inscription());
        } else {
            utilisateur.setDate_inscription(LocalDateTime.now());
        }

        Utilisateur saved = utilisateurRepository.save(utilisateur);

        return utils.convertUtilisateurResponse(saved);
    }

    //recherche d'un user

    public UtilisateurResponse getUtilisateurById(Integer id) {
        
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new UtilisateurNotFoundException(id));

        return utils.convertUtilisateurResponse(utilisateur);
    }

    //MOdifation d'un user par son N

    public UtilisateurResponse updUtilisateur(Integer id, UtilisateurRequest utilisateurRequest) {


            Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new UtilisateurNotFoundException(id));

            if (utilisateurRepository.existsByEmail(utilisateurRequest.getEmail())) {
            throw new EmailAlreadyExistException(utilisateurRequest.getEmail());
            }

            if (utilisateurRequest.getMot_de_passe().length() < 6) {
                throw new InvalidPasswordException();
            }



            utilisateur.setNom(utilisateurRequest.getNom());
            utilisateur.setPrenom(utilisateurRequest.getPrenom());
            utilisateur.setEmail(utilisateurRequest.getEmail());
            utilisateur.setMot_de_passe(utilisateurRequest.getMot_de_passe());
            utilisateur.setTelephone(utilisateurRequest.getTelephone());
            utilisateur.setAdresse(utilisateurRequest.getAdresse());

            if (utilisateurRequest.getDate_inscription() != null) {
                utilisateur.setDate_inscription(utilisateurRequest.getDate_inscription());
            }

            Utilisateur updated = utilisateurRepository.save(utilisateur);

            return utils.convertUtilisateurResponse(updated);
        }



        public void deleteUtilisateur(Integer id) {
            Utilisateur utilisateur = utilisateurRepository.findById(id)
                    .orElseThrow(() -> new UtilisateurNotFoundException(id));
            utilisateurRepository.delete(utilisateur);
        }





}




