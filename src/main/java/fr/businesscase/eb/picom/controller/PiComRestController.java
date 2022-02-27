package fr.businesscase.eb.picom.controller;

import fr.businesscase.eb.picom.business.*;
import fr.businesscase.eb.picom.service.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "ws/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = {"*/*"})
@CrossOrigin(origins = "*")
public class PiComRestController {

    private final UtilisateurService utilisateurService;
    private final ZoneService zoneService;
    private final ClientService clientService;
    private final TrancheHoraireService trancheHoraireService;
    private final AnnonceService annonceService;

    public PiComRestController(UtilisateurService utilisateurService, ZoneService zoneService, ClientService clientService, TrancheHoraireService trancheHoraireService, AnnonceService annonceService) {
        this.utilisateurService = utilisateurService;
        this.zoneService = zoneService;
        this.clientService = clientService;
        this.trancheHoraireService = trancheHoraireService;
        this.annonceService = annonceService;
    }

    //add a administrator
    @PostMapping("admin/{nom}/{prenom}/{email}/{password}")
    public Administrateur ajouterAdmin(@PathVariable String email, @PathVariable String password,
                                       @PathVariable String nom, @PathVariable String prenom) {
        Administrateur administrateur = new Administrateur();
        administrateur.setNom(nom);
        administrateur.setPrenom(prenom);
        administrateur.setEmail(email);
        administrateur.setPassword(password);
        return utilisateurService.enregistrerAdministrateur(administrateur);
    }

    /**
     *
     * @return
     */
    @GetMapping("zones")
    public List<Zone> zonesGet() {
        return zoneService.recupererZones();
    }

    /**
     *
     * @return
     */
    @GetMapping("slots")
    public List<TrancheHoraire> slotsGet() {
        return trancheHoraireService.getSlotTimes();
    }

    /**
     *
     * @param nom
     * @return
     */
    @PostMapping("zones/{nom}")
    public Zone zonesPost(@PathVariable String nom) {
        return zoneService.ajouterZone(nom);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("zones/{id}")
    public boolean zoneDelete(@PathVariable Long id) {
        return zoneService.deleteArea(id);
    }

    /**
     * @param email
     * @param password
     * @return
     */

    @PostMapping("login/{email}/{password}")
    public Utilisateur getPasswordByEmail(@PathVariable String email, @PathVariable String password) {
        Utilisateur user = utilisateurService.recupererUtilisateur(email, password);
        System.out.println("connexion de" + email);
        return user;
    }

    /**
     *
     * @param lastname
     * @param firstname
     * @param email
     * @param password
     * @param numtel
     * @return
     */
    @PostMapping("addCustomer/{lastname}/{firstname}/{email}/{password}/{numtel}")
    public Client addCustomer(@PathVariable String lastname, @PathVariable String firstname,
                              @PathVariable String email, @PathVariable String password, @PathVariable String numtel) {
        Client client = new Client();
        client.setNom(lastname);
        client.setPrenom(firstname);
        client.setEmail(email);
        client.setPassword(password);
        client.setNumeroDeTelephone(numtel);
        return utilisateurService.enregistrerClient(client);
    }


    /**
     * Ajouter une annonce
     *
     * @param annonce
     * @return
     */
    @PostMapping( "advert/{id}")
    public Annonce addAdvert(@RequestBody Annonce annonce, @PathVariable Long id) {
        Client client = clientService.getCustomer(id);
        annonce.setClient(client);
        annonceService.recordAdvert(annonce);
        return annonce;
    }
    
    /**
     * Récupérer les annonces d'un utilisateur
     *
     * @param id
     * @return
     */
    @GetMapping("customer/{id}/adverts")
    public List<Annonce> getAdvertsByCustomer(@PathVariable Long id) {
        Client client = clientService.getCustomer(id);
        return annonceService.getAdvertsByCustomer(client);

    }

    /**
     * Récupérer une annonce par son id
     *
     * @param id
     * @return
     */
    @GetMapping("advert/{id}")
    public Annonce getAdvertById(@PathVariable Long id) {
        return annonceService.recupererAnnonce(id);
    }

    /**
     * Modifie le contenu d'une annonce
     * @param id
     * @param contenu
     * @return
     */
    @PutMapping("advert/{id}/{contenu}")
    Annonce modifierAnnonce(@PathVariable Long id, @PathVariable String contenu) {
        Annonce annonce = annonceService.recupererAnnonce(id);
        return annonceService.modifierContenuAnnonce(annonce, contenu);
    }

}