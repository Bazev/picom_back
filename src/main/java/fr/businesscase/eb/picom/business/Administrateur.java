package fr.businesscase.eb.picom.business;

import javax.persistence.Entity;

@Entity
public class Administrateur extends Utilisateur {

    public Administrateur() {
    }

    public Administrateur(String nom, String prenom, String email, String password) {
        super(nom, prenom, email, password);
    }

    public Administrateur(String email, String password) {
    }
}