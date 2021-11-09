package fr.businesscase.eb.picom.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class AdvertHtml extends Advert {
    @Column(name = "contenu")
    private String contenu;

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public AdvertHtml() {
    }

    public AdvertHtml(Date dateCreation, Date dateDebut, Date dateFin, Customer customer, List<Area> areas, List<SlotTime> slotTimes, String intitule, String contenu) {
        super(dateCreation, dateDebut, dateFin, customer, areas, slotTimes, intitule);
        this.contenu = contenu;
    }
}