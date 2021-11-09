package fr.businesscase.eb.picom.service.impl;

import fr.businesscase.eb.picom.business.Arret;
import fr.businesscase.eb.picom.business.Area;
import fr.businesscase.eb.picom.Repository.ArretRepository;
import fr.businesscase.eb.picom.service.ArretService;
import fr.businesscase.eb.picom.service.AreaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArretServiceImpl implements ArretService {

    private final ArretRepository arretRepository;
    private final AreaService areaService;

    public ArretServiceImpl(ArretRepository arretRepository, AreaService areaService) {
        this.arretRepository = arretRepository;
        this.areaService = areaService;
    }


    @Override
    public Arret ajouterArret(String nom, Long idZone) {
        Area area = areaService.getArea(idZone);
        if (area == null) {
            return null;
        }
        else {
            return arretRepository.save(new Arret(area, nom));
        }
    }


    @Override
    public Arret enregistrerArret(Arret arret) {
        return arretRepository.save(arret);
    }

    @Override
    public List<Arret> recupererArrets() {
        return arretRepository.findAll();
    }

    @Override
    public List<Arret> recupererArrets(Area area) {
        return arretRepository.findByArea(area);
    }
}
