package fr.businesscase.eb.picom.service.impl;

import fr.businesscase.eb.picom.Dao.ZoneDao;
import fr.businesscase.eb.picom.business.Zone;
import fr.businesscase.eb.picom.service.ZoneService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {
    private final ZoneDao zoneDao;

    public ZoneServiceImpl(ZoneDao zoneDao) {
        this.zoneDao = zoneDao;
    }

    @Override
    public Zone ajouterZone(String nom) {
        return zoneDao.save(new Zone(nom));
    }

    @Override
    public Zone recupererZone(Long id) {
        return zoneDao.findById(id).orElse(null);
    }

    @Override
    public Zone recupererZone(String nom) {
        return zoneDao.findByName(nom);
    }

    @Override
    public Zone enregistrerZone(Zone zone) {
        return zoneDao.save(zone);
    }

    @Override
    public List<Zone> recupererZones() {
        return zoneDao.findAll();
    }

    @Override
    public Page<Zone> recupererZones(Pageable pageable) {
        return zoneDao.findAll(pageable);
    }

    @Override
    public boolean deleteArea(Long id) {
        Zone zone = recupererZone(id);
        if (zone != null) {
            zoneDao.delete(zone);
            return true;
        }
        return false;
    }
}
