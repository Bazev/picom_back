package fr.businesscase.eb.picom.Repository;

import fr.businesscase.eb.picom.business.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Area, Long> {

    Area findByName(String nom);
}