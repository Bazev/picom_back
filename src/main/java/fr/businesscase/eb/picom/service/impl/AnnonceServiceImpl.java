package fr.businesscase.eb.picom.service.impl;

import fr.businesscase.eb.picom.Dao.AnnonceDao;
import fr.businesscase.eb.picom.Dao.AnnonceImageDao;
import fr.businesscase.eb.picom.business.*;
import fr.businesscase.eb.picom.service.AnnonceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    private final AnnonceDao annonceDao;
    private final AnnonceImageDao annonceImageDao;

    public AnnonceServiceImpl(AnnonceDao annonceDao, AnnonceImageDao annonceImageDao) {
        this.annonceDao = annonceDao;
        this.annonceImageDao = annonceImageDao;
    }

    @Override
    public List<Annonce> recupererAnnonces() {
        return annonceDao.findAll();
    }

    @Override
    public List<Annonce> getAdvertsByCustomer(Client client) {
        return annonceDao.findByClient(client);
    }

    @Override
    public Annonce recordAdvert(Annonce annonce) {
        return annonceDao.save(annonce);
    }

    @Override
    public Page<Annonce> recupererAnnonces(String filtre, Pageable pageable) {
        return annonceDao.findByTitreContaining(filtre, pageable);
    }

    @Override
    public Page<Annonce> recupererAnnonces(Utilisateur utilisateurEnSession, String filtre, Pageable pageable) {
        return annonceDao.findByTitreContainingAndIdNot(utilisateurEnSession, filtre, pageable);
    }

    @Override
    public Object recupererAnnonces(Pageable pageable, Client client) {
        return annonceDao.findByClient(pageable, client);
    }

    @Override
    public Page<Annonce> recupererAnnonces(Pageable pageable) {
        return annonceDao.findAll(pageable);
    }

    @Override
    public Annonce recupererAnnonce(Long id) {
        return annonceDao.findById(id).orElse(null);
    }

    @Override
    public Annonce modifierContenuAnnonce(Annonce annonce, String contenu) {
        annonce.setContenu(contenu);
        return annonceDao.save(annonce);
    }

    @Override
    public AnnonceImage enregistrerAnnonceImage(AnnonceImage annonceImage) {
        return annonceImageDao.save(annonceImage);
    }

    @Override
    public boolean supprimerAnnonce(Long id) {
        Annonce annonce = recupererAnnonce(id);
        if (annonce!=null) {
            annonceDao.deleteById(id);
            return true;
        }
        return false;
    }

}
