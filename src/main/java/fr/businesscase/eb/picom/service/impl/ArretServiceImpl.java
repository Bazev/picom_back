package fr.businesscase.eb.picom.service.impl;

import fr.businesscase.eb.picom.business.Arret;
import fr.businesscase.eb.picom.business.Zone;
import fr.businesscase.eb.picom.Dao.ArretDao;
import fr.businesscase.eb.picom.service.ArretService;
import fr.businesscase.eb.picom.service.ZoneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArretServiceImpl implements ArretService {

    private final ArretDao arretDao;
    private final ZoneService zoneService;

    public ArretServiceImpl(ArretDao arretDao, ZoneService zoneService) {
        this.arretDao = arretDao;
        this.zoneService = zoneService;
    }


    @Override
    public Arret ajouterArret(String nom, Long idZone) {
        Zone zone = zoneService.recupererZone(idZone);
        if (zone == null) {
            return null;
        }
        else {
            return arretDao.save(new Arret(zone, nom));
        }
    }


    @Override
    public Arret enregistrerArret(Arret arret) {
        return arretDao.save(arret);
    }

    @Override
    public List<Arret> recupererArrets() {
        return arretDao.findAll();
    }

    @Override
    public List<Arret> recupererArrets(Zone zone) {
        return arretDao.findByZone(zone);
    }
}
