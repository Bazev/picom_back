package fr.businesscase.eb.picom.business;

import javax.persistence.*;
import java.util.List;

@Table(name = "slot_time")
@Entity
public class SlotTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "start")
    private int start;

    @ManyToMany(mappedBy = "slotTimes")
    private List<Advert> adverts;


    public SlotTime(int start) {
        this.start = start;
    }

    public SlotTime() {

    }

    public List<Advert> getAnnonces() {
        return adverts;
    }

    public void setAnnonces(List<Advert> adverts) {
        this.adverts = adverts;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "start = " + start + ")";
    }
}