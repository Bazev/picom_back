package fr.businesscase.eb.picom.business;

import javax.persistence.*;

@Table(name = "carte_bancaire")
@Entity
public class CarteBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Customer customer;

    @Column(name = "numero_carte")
    private String numeroCarte;

    @Column(name = "annee_expiration")
    private Integer anneeExpiration;

    @Column(name = "mois_expiration")
    private Byte moisExpiration;

    @Column(name = "cryptogramme")
    private String cryptogramme;

    public CarteBancaire() {
    }

    public String getCryptogramme() {
        return cryptogramme;
    }

    public void setCryptogramme(String cryptogramme) {
        this.cryptogramme = cryptogramme;
    }

    public Byte getMoisExpiration() {
        return moisExpiration;
    }

    public void setMoisExpiration(Byte moisExpiration) {
        this.moisExpiration = moisExpiration;
    }

    public Integer getAnneeExpiration() {
        return anneeExpiration;
    }

    public void setAnneeExpiration(Integer anneeExpiration) {
        this.anneeExpiration = anneeExpiration;
    }

    public String getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getClient() {
        return customer;
    }

    public void setClient(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "client = " + customer + ", " +
                "numeroCarte = " + numeroCarte + ", " +
                "anneeExpiration = " + anneeExpiration + ", " +
                "moisExpiration = " + moisExpiration + ", " +
                "cryptogramme = " + cryptogramme + ")";
    }
}