package fr.businesscase.eb.picom.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "slot_time")
@Entity
public class TrancheHoraire implements Serializable {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "start")
    private int start;

    @JsonIgnore
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST})
    @ManyToMany(mappedBy = "trancheHoraires")
    private List<Annonce> annonces;

    public TrancheHoraire() {
    }

    public TrancheHoraire(int start) {
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

    public List<Annonce> getAdverts() {
        return annonces;
    }

    public void setAdverts(List<Annonce> annonces) {
        this.annonces = annonces;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "start = " + start + ")";
    }
}