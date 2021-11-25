package fr.businesscase.eb.picom.business;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class AdvertImage extends Advert implements Serializable {


    public AdvertImage() {
    }


    @Override
    public String toString() {
        return "AdvertImage{}";
    }
}