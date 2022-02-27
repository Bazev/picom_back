package fr.businesscase.eb.picom.service.impl;

import fr.businesscase.eb.picom.Dao.AdministrateurDao;
import fr.businesscase.eb.picom.Dao.UtilisateurDao;
import fr.businesscase.eb.picom.business.Administrateur;
import fr.businesscase.eb.picom.business.Client;
import fr.businesscase.eb.picom.business.Utilisateur;
import fr.businesscase.eb.picom.service.UtilisateurService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurDao utilisateurDao;
    private final AdministrateurDao administrateurDao;

    public UtilisateurServiceImpl(UtilisateurDao utilisateurDao, AdministrateurDao administrateurDao) {
        this.utilisateurDao = utilisateurDao;
        this.administrateurDao = administrateurDao;
    }


    @Override
    public Client enregistrerClient(Client client) {
        return utilisateurDao.save(client);
    }

    @Override
    public Administrateur enregistrerAdministrateur(Administrateur administrateur) {
        return administrateurDao.save(administrateur);
    }

    @Override
    public Utilisateur recupererUtilisateur(String email, String password) {
        return utilisateurDao.findByEmailAndPassword(email, password);
    }

    @Override
    public Page<Utilisateur> recupererUtilisateurs(Pageable pageable) {
        return utilisateurDao.findAll(pageable);
    }

    @Override
    public Page<Utilisateur> recupererUtilisateurs(Pageable pageable, String filtreNom) {
        return utilisateurDao.findAll(pageable);
    }

    @Override
    public List<Utilisateur> getUsers() {
        return utilisateurDao.findAll();
    }

    @Override
    public Utilisateur recupererUtilisateur(Long id) {
        return utilisateurDao.findById(id).orElse(null);
    }

    @Override
    public long compterNbUtilisateurs() {
        return utilisateurDao.count();
    }


}