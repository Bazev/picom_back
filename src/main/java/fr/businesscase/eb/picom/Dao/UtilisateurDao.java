package fr.businesscase.eb.picom.Dao;

import fr.businesscase.eb.picom.business.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByEmailAndPassword(String email, String password);

    Page<Utilisateur> findByNomContaining(Pageable pageable, String nom);

}