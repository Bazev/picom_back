package fr.businesscase.eb.picom.business;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public abstract class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_creation")
    @DateTimeFormat(pattern = "yyyy-mm-jj")
    private Date dateCreation;

    @NotNull(message = "Merci de préciser la date de début où l'annonce doit être diffusé")
    @Temporal(TemporalType.DATE)
    @Column(name = "date_debut")
    @DateTimeFormat(pattern = "yyyy-mm-jj")
    private Date dateDebut;

    @NotNull(message = "Merci de préciser la de fin où l'annonce doit se terminer")
    @Temporal(TemporalType.DATE)
    @Column(name = "date_fin")
    private Date dateFin;

    @NotNull(message = "Merci de préciser le client")
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "advert_zones",
            joinColumns = @JoinColumn(name = "advert_id"),
            inverseJoinColumns = @JoinColumn(name = "zones_id"))
    private List<Area> areas;

    @ManyToMany
    @JoinTable(name = "advert_slot_time",
            joinColumns = @JoinColumn(name = "advert_id"),
            inverseJoinColumns = @JoinColumn(name = "slot_times_id"))
    private List<SlotTime> slotTimes;

    @Column(name = "intitule")
    private String intitule;

    public Advert() {
        dateCreation = new Date();
    }

    public Advert(Date dateCreation, Date dateDebut, Date dateFin, Customer customer, List<Area> areas, List<SlotTime> slotTimes, String intitule) {
        this.dateCreation = dateCreation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.customer = customer;
        this.areas = areas;
        this.slotTimes = slotTimes;
        this.intitule = intitule;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public List<SlotTime> getSlotTimes() {
        return slotTimes;
    }

    public void setSlotTimes(List<SlotTime> slotTimes) {
        this.slotTimes = slotTimes;
    }

    public List<Area> getZones() {
        return areas;
    }

    public void setZones(List<Area> areas) {
        this.areas = areas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "dateCreation = " + dateCreation + ", " +
                "dateDebut = " + dateDebut + ", " +
                "dateFin = " + dateFin + ", " +
                "customer = " + customer + ", " +
                "intitule = " + intitule + ")";
    }
}
