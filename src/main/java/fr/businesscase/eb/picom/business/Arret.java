package fr.businesscase.eb.picom.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Table(name = "arret")
@Entity
public class Arret implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @NotBlank(message = "Champ obligatoire")
    @Column(name = "nom")
    private String nom;

    public Arret() {
    }

    public Arret(Zone zone, String nom) {
        this.zone = zone;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String name) {
        this.nom = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "area = " + zone + ", " +
                "name = " + nom + ")";
    }
}