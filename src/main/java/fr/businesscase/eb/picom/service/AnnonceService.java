package fr.businesscase.eb.picom.service;

import fr.businesscase.eb.picom.business.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface AnnonceService {

    List<Annonce> recupererAnnonces();

    List<Annonce> getAdvertsByCustomer(Client client);

    Annonce recordAdvert(Annonce annonce);

    Page<Annonce> recupererAnnonces(String filtre, Pageable pageable);

    Page<Annonce> recupererAnnonces(Utilisateur utilisateurEnSession, String filtre, Pageable pageable);

    Object recupererAnnonces(Pageable pageable, Client client);

    Page<Annonce> recupererAnnonces(Pageable pageable);

    Annonce recupererAnnonce(Long id);
    

    Annonce modifierContenuAnnonce(Annonce annonce, String contenu);

    AnnonceImage enregistrerAnnonceImage(AnnonceImage annonceImage);

    boolean supprimerAnnonce(Long id);
}
