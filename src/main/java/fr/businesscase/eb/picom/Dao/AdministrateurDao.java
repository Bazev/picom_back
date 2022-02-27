package fr.businesscase.eb.picom.Dao;

import fr.businesscase.eb.picom.business.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurDao extends JpaRepository<Administrateur, Long> {
}