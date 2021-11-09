package fr.businesscase.eb.picom.business;

import javax.persistence.Entity;

@Entity
public class Administrator extends User {

    public Administrator() {
    }

    public Administrator(String nom, String prenom, String email, String password) {
        super(nom, prenom, email, password);
    }

    public Administrator(String email, String password) {
    }
}