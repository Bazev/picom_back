package fr.businesscase.eb.picom.Dao;

import fr.businesscase.eb.picom.business.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneDao extends JpaRepository<Zone, Long> {

    Zone findByName(String nom);
}