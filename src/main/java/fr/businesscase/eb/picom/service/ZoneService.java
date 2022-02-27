package fr.businesscase.eb.picom.service;

import fr.businesscase.eb.picom.business.Zone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ZoneService {

    Zone ajouterZone(String nom);
    Zone recupererZone(Long id);
    Zone recupererZone(String nom);
    Zone enregistrerZone(Zone zone);
    List<Zone> recupererZones();
    Page<Zone> recupererZones(Pageable pageable);
    boolean deleteArea(Long id);
}
