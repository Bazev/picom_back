package fr.businesscase.eb.picom.business;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "advert")
@Entity
public class Annonce implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_creation")
    @DateTimeFormat(pattern = "yyyy-mm-jj")
    private Date dateCreation;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_start")
    @DateTimeFormat(pattern = "jj-mm-yyyy")
    @NotNull(message = "Date de début requis")
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_end")
    @DateTimeFormat(pattern = "jj-mm-yyyy")
    @NotNull(message = "Date de fin requis")
    private Date dateFin;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST})
    @NotNull(message = "Créneaux requis")
    private List<TrancheHoraire> trancheHoraires;

    @ManyToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST})
    @NotNull(message = "Zone requis")
    private List<Zone> zones;

    @Column(name = "title")
    @NotNull(message = "Titre requis")
    private String titre;

    @Column(name = "contenu")
    private String contenu;

    public Annonce() {
    }

    public Annonce(Date dateDebut, Date dateFin, Client client, List<Zone> zones, List<TrancheHoraire> trancheHoraires, String titre) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.zones = zones;
        this.trancheHoraires = trancheHoraires;
        this.titre = titre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreate) {
        this.dateCreation = dateCreate;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateStart) {
        this.dateDebut = dateStart;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateEnd) {
        this.dateFin = dateEnd;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<TrancheHoraire> getTrancheHoraires() {
        return trancheHoraires;
    }

    public void setTrancheHoraires(List<TrancheHoraire> trancheHoraires) {
        this.trancheHoraires = trancheHoraires;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Advert{" +
                "id=" + id +
                ", dateCreation=" + dateCreation +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", client=" + client +
                ", titre='" + titre + '\'' +
                ", contenu='" + contenu + '\'' +
                '}';
    }
}
