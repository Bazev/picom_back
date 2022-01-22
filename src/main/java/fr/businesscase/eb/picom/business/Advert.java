package fr.businesscase.eb.picom.business;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Advert  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_create")
    @DateTimeFormat(pattern = "yyyy-mm-jj")
    private Date dateCreate;

    @NotNull(message = "Merci de préciser la date de début où l'annonce doit être diffusé")
    @Temporal(TemporalType.DATE)
    @Column(name = "date_start")
    @DateTimeFormat(pattern = "yyyy-mm-jj")
    private Date dateStart;

    @NotNull(message = "Merci de préciser la de fin où l'annonce doit se terminer")
    @Temporal(TemporalType.DATE)
    @Column(name = "date_end")
    private Date dateEnd;

    @JsonIgnore
    @NotNull(message = "Merci de préciser le client")
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    private List<Area> areas;

    @ManyToMany
    private List<SlotTime> slotTimes;

    @Column(name = "title")
    private String title;

    @Column(name = "contenu")
    private String contenu;

    public Advert(Long id, Date dateCreate, Date dateStart, Date dateEnd, Customer customer, List<Area> areas, List<SlotTime> slotTimes, String title) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.customer = customer;
        this.areas = areas;
        this.slotTimes = slotTimes;
        this.title = title;
    }

    public Advert(Long id, Date dateCreate, Date dateStart, Date dateEnd, Customer customer, List<Area> areas, List<SlotTime> slotTimes, String title, String contenu) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.customer = customer;
        this.areas = areas;
        this.slotTimes = slotTimes;
        this.title = title;
        this.contenu = contenu;
    }

    public Advert() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public List<SlotTime> getSlotTimes() {
        return slotTimes;
    }

    public void setSlotTimes(List<SlotTime> slotTimes) {
        this.slotTimes = slotTimes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
