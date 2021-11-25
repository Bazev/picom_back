package fr.businesscase.eb.picom.Repository;

import fr.businesscase.eb.picom.business.SlotTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotTimeRepository extends JpaRepository<SlotTime, Long> {

    SlotTime findByStart(int debut);
}