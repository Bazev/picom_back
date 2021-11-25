package fr.businesscase.eb.picom.business;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "slot_time")
@Entity
public class SlotTime implements Serializable {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "start")
    private int start;

    @JsonIgnore
    @ManyToMany(mappedBy = "slotTimes")
    private List<Advert> adverts;

    public SlotTime() {
    }

    public SlotTime(int start) {
        this.start = start;
    }



    public int getStart() {
        return start;
    }

    public void setStart(int debut) {
        this.start = debut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "start = " + start + ")";
    }
}