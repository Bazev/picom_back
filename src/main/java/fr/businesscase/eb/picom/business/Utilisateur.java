package fr.businesscase.eb.picom.business;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table(name = "users")
@Entity
public abstract class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @NotBlank(message = "Merci de préciser un nom")
    @Column(name = "nom")
    private String nom;

    @JsonIgnore
    @NotBlank(message = "Merci de préciser un prenom")
    @Column(name = "prenom")
    private String prenom;

    @JsonIgnore
    @NotBlank(message = "Merci de rentrer votre e-mail")
    @Email(message = "Merci de préciser un email au bon format")
    @Column(name = "email", unique = true)
    private String email;

    @JsonIgnore
    @Size(message = "Merci de saisir un mot de passe contenant 8 caractère minimum", min = 8)
    @NotBlank(message = "Merci de préciser un mot de passe")
    @Column(name = "password")
    private String password;


    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}