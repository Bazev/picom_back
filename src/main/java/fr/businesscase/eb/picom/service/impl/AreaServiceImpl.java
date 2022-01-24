package fr.businesscase.eb.picom.service.impl;

import fr.businesscase.eb.picom.Repository.ZoneRepository;
import fr.businesscase.eb.picom.business.Area;
import fr.businesscase.eb.picom.service.AreaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    private final ZoneRepository zoneRepository;

    public AreaServiceImpl(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Override
    public Area addArea(String nom) {
        return zoneRepository.save(new Area(nom));
    }

    @Override
    public Area getArea(Long id) {
        return zoneRepository.findById(id).orElse(null);
    }

    @Override
    public Area getArea(String nom) {
        return zoneRepository.findByName(nom);
    }

    @Override
    public Area recordArea(Area area) {
        return zoneRepository.save(area);
    }

    @Override
    public List<Area> getAreas() {
        return zoneRepository.findAll();
    }

    @Override
    public boolean deleteArea(Long id) {
        Area area = getArea(id);
        if (area != null) {
            zoneRepository.delete(area);
            return true;
        }
        return false;
    }
}
