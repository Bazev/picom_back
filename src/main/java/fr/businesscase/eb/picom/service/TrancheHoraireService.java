package fr.businesscase.eb.picom.service;

import fr.businesscase.eb.picom.business.TrancheHoraire;

import java.util.List;

public interface TrancheHoraireService {

    TrancheHoraire addSlotTime(int debut);

    List<TrancheHoraire> getSlotTimes();

    TrancheHoraire getSlotTime(int debut);

    TrancheHoraire getHoure(Long id);

    TrancheHoraire recordSlotTime(TrancheHoraire trancheHoraire);


}
