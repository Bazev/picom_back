package fr.businesscase.eb.picom.service;

import fr.businesscase.eb.picom.business.Administrateur;
import fr.businesscase.eb.picom.business.Client;
import fr.businesscase.eb.picom.business.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface UtilisateurService {

    Client enregistrerClient(Client client);

    Administrateur enregistrerAdministrateur(Administrateur administrateur);

    Utilisateur recupererUtilisateur(String email, String password);

    Page<Utilisateur> recupererUtilisateurs(Pageable pageable);

    Page<Utilisateur> recupererUtilisateurs(Pageable pageable, String filtreNom);

    List<Utilisateur> getUsers();

    Utilisateur recupererUtilisateur(Long id);

    long compterNbUtilisateurs();
}
