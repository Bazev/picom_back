package fr.businesscase.eb.picom.business;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer extends User {

    @Length(max = 15)
    @Column(name = "numero_tel", unique = true)
    private String numeroTel;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Advert> adverts;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<CarteBancaire> carteBancaires;

    public Customer() {
    }

    public Customer(String nom, String prenom, String email, String password, String numeroTel) {
        super(nom, prenom, email, password);
        this.numeroTel = numeroTel;
    }

    public List<CarteBancaire> getCarteBancaires() {
        return carteBancaires;
    }

    public void setCarteBancaires(List<CarteBancaire> carteBancaires) {
        this.carteBancaires = carteBancaires;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "numeroTel = " + getNumeroTel() + ", " +
                "nom = " + getLastName() + ", " +
                "prenom = " + getFirstName() + ", " +
                "email = " + getEmail() + ", " +
                "password = " + getPassword() + ")";
    }
}