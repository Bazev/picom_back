package fr.businesscase.eb.picom.Repository;

import fr.businesscase.eb.picom.business.Arret;
import fr.businesscase.eb.picom.business.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArretRepository extends JpaRepository<Arret, Long> {

    List<Arret> findByArea(Area area);
}