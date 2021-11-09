package fr.businesscase.eb.picom.service;

import fr.businesscase.eb.picom.business.Arret;
import fr.businesscase.eb.picom.business.Area;

import java.util.List;

public interface ArretService {

    Arret ajouterArret(String nom, Long idZone);
    Arret enregistrerArret(Arret arret);

    List<Arret> recupererArrets();
    List<Arret> recupererArrets(Area area);


}
