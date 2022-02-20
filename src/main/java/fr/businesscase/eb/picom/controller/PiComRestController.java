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

    private final UsersService usersService;
    private final AreaService areaService;
    private final CustomerService customerService;
    private final SlotTimeService slotTimeService;
    private final AdvertService advertService;

    public PiComRestController(UsersService usersService, AreaService areaService, CustomerService customerService, SlotTimeService slotTimeService, AdvertService advertService) {
        this.usersService = usersService;
        this.areaService = areaService;
        this.customerService = customerService;
        this.slotTimeService = slotTimeService;
        this.advertService = advertService;
    }

    //add a administrator
    @PostMapping("admin/{nom}/{prenom}/{email}/{password}")
    public Administrator ajouterAdmin(@PathVariable String email, @PathVariable String password,
                                      @PathVariable String nom, @PathVariable String prenom) {
        Administrator administrator = new Administrator();
        administrator.setLastName(nom);
        administrator.setFirstName(prenom);
        administrator.setEmail(email);
        administrator.setPassword(password);
        return usersService.recordAdministrator(administrator);
    }

    /**
     *
     * @return
     */
    @GetMapping("zones")
    public List<Area> zonesGet() {
        return areaService.getAreas();
    }

    /**
     *
     * @return
     */
    @GetMapping("slots")
    public List<SlotTime> slotsGet() {
        return slotTimeService.getSlotTimes();
    }

    /**
     *
     * @param nom
     * @return
     */
    @PostMapping("zones/{nom}")
    public Area zonesPost(@PathVariable String nom) {
        return areaService.addArea(nom);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("zones/{id}")
    public boolean zoneDelete(@PathVariable Long id) {
        return areaService.deleteArea(id);
    }

    /**
     * @param email
     * @param password
     * @return
     */

    @PostMapping("login/{email}/{password}")
    public User getPasswordByEmail(@PathVariable String email, @PathVariable String password) {
        User user = usersService.getUser(email, password);
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
    public Customer addCustomer(@PathVariable String lastname, @PathVariable String firstname,
                                @PathVariable String email, @PathVariable String password, @PathVariable String numtel) {
        Customer customer = new Customer();
        customer.setLastName(lastname);
        customer.setFirstName(firstname);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setNumeroTel(numtel);
        return usersService.recordCustomer(customer);
    }


    /**
     * Ajouter une annonce
     *
     * @param advert
     * @return
     */
    @PostMapping( "advert/{id}")
    public Advert addAdvert(@RequestBody Advert advert, @PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
        advert.setCustomer(customer);
        advertService.recordAdvert(advert);
        return advert;
    }
    
    /**
     * Récupérer les annonces d'un utilisateur
     *
     * @param id
     * @return
     */
    @GetMapping("customer/{id}/adverts")
    public List<Advert> getAdvertsByCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
        return advertService.getAdvertsByCustomer(customer);

    }

    /**
     * Récupérer une annonce par son id
     *
     * @param id
     * @return
     */
    @GetMapping("advert/{id}")
    public Advert getAdvertById(@PathVariable Long id) {
        return advertService.getAdvert(id);
    }

    /**
     * Modifie le contenu d'une annonce
     * @param id
     * @param contenu
     * @return
     */
    @PutMapping("advert/{id}/{contenu}")
    Advert modifierAnnonce(@PathVariable Long id, @PathVariable String contenu) {
        Advert advert = advertService.getAdvert(id);
        return advertService.modifierContenuAnnonce(advert, contenu);
    }

}