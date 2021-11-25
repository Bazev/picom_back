package fr.businesscase.eb.picom.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class AdvertHtml extends Advert implements Serializable {

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

    @Override
    public String toString() {
        return "AdvertHtml{" +
                "contenu='" + contenu + '\'' +
                '}';
    }
}