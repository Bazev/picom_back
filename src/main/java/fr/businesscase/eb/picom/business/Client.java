package fr.businesscase.eb.picom.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Client extends Utilisateur implements Serializable {

    @Length(max = 15)
    @Column(name = "numero_tel", unique = true)
    private String numeroDeTelephone;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Annonce> annonces;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<CarteBancaire> carteBancaires;

    public Client() {
    }

    public Client(String nom, String prenom, String email, String password, String numeroDeTelephone) {
        super(nom, prenom, email, password);
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public List<CarteBancaire> getCarteBancaires() {
        return carteBancaires;
    }

    public void setCarteBancaires(List<CarteBancaire> carteBancaires) {
        this.carteBancaires = carteBancaires;
    }

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }

    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    public void setNumeroDeTelephone(String numeroTel) {
        this.numeroDeTelephone = numeroTel;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "numeroTel = " + getNumeroDeTelephone() + ", " +
                "nom = " + getNom() + ", " +
                "prenom = " + getPrenom() + ", " +
                "email = " + getEmail() + ", " +
                "password = " + getPassword() + ")";
    }
}