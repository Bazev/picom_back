package fr.businesscase.eb.picom.service.impl;

import fr.businesscase.eb.picom.Dao.TrancheHoraireDao;
import fr.businesscase.eb.picom.business.TrancheHoraire;
import fr.businesscase.eb.picom.service.TrancheHoraireService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrancheHoraireServiceImpl implements TrancheHoraireService {

    private final TrancheHoraireDao trancheHoraireDao;

    public TrancheHoraireServiceImpl(TrancheHoraireDao trancheHoraireDao) {
        this.trancheHoraireDao = trancheHoraireDao;
    }

    @Override
    public TrancheHoraire addSlotTime(int debut) {
        return trancheHoraireDao.save(new TrancheHoraire(debut));
    }

    @Override
    public List<TrancheHoraire> getSlotTimes() {
        return trancheHoraireDao.findAll();
    }

    @Override
    public TrancheHoraire getSlotTime(int debut) {
        return trancheHoraireDao.findByStart(debut);
    }

    @Override
    public TrancheHoraire getHoure(Long id) {
        return trancheHoraireDao.getById(id);
    }

    @Override
    public TrancheHoraire recordSlotTime(TrancheHoraire trancheHoraire) {
        return trancheHoraireDao.save(trancheHoraire);
    }
}
