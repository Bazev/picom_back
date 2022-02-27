package fr.businesscase.eb.picom.Dao;

import fr.businesscase.eb.picom.business.Annonce;
import fr.businesscase.eb.picom.business.Client;
import fr.businesscase.eb.picom.business.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnonceDao extends JpaRepository<Annonce, Long> {

    Page<Annonce> findByTitreContaining(String filtre, Pageable pageable);

    Page<Annonce> findByTitreContainingAndIdNot(Utilisateur utilisateurEnSession, String filtre, Pageable pageable);

    Page<Annonce> findByClient(Pageable pageable, Client client);

    List<Annonce> findByClient(Client client);

}
