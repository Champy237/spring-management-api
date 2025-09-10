package com.ecommerce.API_gestion.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.API_gestion.dto.commande.CommandeRequest;
import com.ecommerce.API_gestion.dto.commande.CommandeResponse;
import com.ecommerce.API_gestion.exceptions.Commande.CommandeNotFoundException;
import com.ecommerce.API_gestion.exceptions.Commande.InvalidStatutCommandeException;
import com.ecommerce.API_gestion.exceptions.Utilisateur.UtilisateurNotFoundException;
import com.ecommerce.API_gestion.models.Commande;
import com.ecommerce.API_gestion.models.Utilisateur;
import com.ecommerce.API_gestion.repository.CommandeRepository;
import com.ecommerce.API_gestion.repository.UtilisateurRepository;
import com.ecommerce.API_gestion.utils.Utils;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private Utils utils;

    // Liste toutes les commandes
    public List<CommandeResponse> getAllCommandes() {
        List<Commande> commandesList = commandeRepository.findAll();
        List<CommandeResponse> responses = new ArrayList<>();

        for (Commande commande : commandesList) {
            responses.add(utils.convCommandeResponse(commande));
        }
        return responses;
    }

    // Création d'une commande
    public CommandeResponse creaCommande(CommandeRequest request) {

        Commande commande = new Commande();

        commande.setId(request.getId());

        commande.setMontant_total(request.getMontant_total());

        commande.setCreatedAt(LocalDateTime.now());



        Utilisateur utilisateur =  utilisateurRepository.findById(request.getUtilisateur_id())
                    .orElseThrow(() -> new UtilisateurNotFoundException(request.getUtilisateur_id()));
        commande.setUtilisateurs(utilisateur);

        commande.setStatut(Commande.Status.EN_ATTENT);        

        Commande saved = commandeRepository.save(commande);
        return utils.convCommandeResponse(saved);
    }

    // Recherche par id
    public CommandeResponse getCommandeById(Integer id) {
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new CommandeNotFoundException(id));
        return utils.convCommandeResponse(commande);
    }

    // Mise à jour
    public CommandeResponse updCommande(Integer id, CommandeRequest request) {
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new CommandeNotFoundException(id));

        if (!isValidStatut(request.getStatut())) {
            throw new InvalidStatutCommandeException(request.getStatut());
        }


        commande.setId(request.getId());

        commande.setMontant_total(request.getMontant_total());

        commande.setStatut(commande.getStatut());

        commande.setCreatedAt(LocalDateTime.now());
        
        Utilisateur utilisateur =  utilisateurRepository.findById(request.getUtilisateur_id()).orElseThrow(() -> new UtilisateurNotFoundException(request.getUtilisateur_id()));
        commande.setUtilisateurs(utilisateur);


        Commande updated = commandeRepository.save(commande);
        return utils.convCommandeResponse(updated);
    }

    // Suppression
    public void deleteCommande(Integer id) {
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new CommandeNotFoundException(id));
        commandeRepository.delete(commande);
    }

    // Vérifie le statut valide
    private boolean isValidStatut(String statut) {
        return statut != null && (statut.equalsIgnoreCase("EN_ATTENTE")
                || statut.equalsIgnoreCase("CONFIRMEE")
                || statut.equalsIgnoreCase("LIVREE"));
    }
}
