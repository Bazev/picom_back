package fr.businesscase.eb.picom.business;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class AdvertImage extends Advert {

    public AdvertImage(Date dateCreation, Date dateDebut, Date dateFin, Customer customer,
                       List<Area> areas, List<SlotTime> slotTimes, String intitule) {
        super(dateCreation, dateDebut, dateFin, customer, areas, slotTimes, intitule);
    }

    public AdvertImage() {
    }

    @Override
    public String toString() {
        return "AdvertImage{}";
    }
}