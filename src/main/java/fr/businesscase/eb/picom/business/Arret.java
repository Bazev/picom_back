package fr.businesscase.eb.picom.business;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name = "arret")
@Entity
public class Arret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @NotBlank(message = "Champ obligatoire")
    @Column(name = "nom")
    private String nom;

    public Arret() {
    }

    public Arret(Area area, String nom) {
        this.area = area;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "area = " + area + ", " +
                "nom = " + nom + ")";
    }
}