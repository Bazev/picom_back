package fr.businesscase.eb.picom.Dao;

import fr.businesscase.eb.picom.business.Arret;
import fr.businesscase.eb.picom.business.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArretDao extends JpaRepository<Arret, Long> {

    List<Arret> findByZone(Zone zone);
}