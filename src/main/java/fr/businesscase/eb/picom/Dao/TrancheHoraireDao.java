package fr.businesscase.eb.picom.Dao;

import fr.businesscase.eb.picom.business.TrancheHoraire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrancheHoraireDao extends JpaRepository<TrancheHoraire, Long> {

    TrancheHoraire findByStart(int debut);
}