package fr.businesscase.eb.picom.business;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table(name = "users")
@Entity
public abstract class User {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Merci de préciser un nom")
    @Column(name = "lastName")
    private String lastName;

    @NotBlank(message = "Merci de préciser un prenom")
    @Column(name = "firstName")
    private String firstName;

    @NotBlank(message = "Merci de rentrer votre e-mail")
    @Email(message = "Merci de préciser un email au bon format")
    @Column(name = "email", unique = true)
    private String email;

    @Size(message = "Merci de saisir un mot de passe contenant 8 caractère minimum", min = 8)
    @NotBlank(message = "Merci de préciser un mot de passe")
    @Column(name = "password")
    private String password;


    public User() {
    }

    public User(String lastName, String firstName, String email, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}