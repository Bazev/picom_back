package fr.businesscase.eb.picom.controller;

import fr.businesscase.eb.picom.business.*;
import fr.businesscase.eb.picom.service.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("ws/")
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
    @PostMapping("admin/{nom}/{prenom}{email}/{password}")
    public Administrator ajouterAdmin(@PathVariable String email, @PathVariable String password,
                                      @PathVariable String nom, @PathVariable String prenom) {
        Administrator administrator = new Administrator();
        administrator.setLastName(nom);
        administrator.setFirstName(prenom);
        administrator.setEmail(email);
        administrator.setPassword(password);
        return usersService.recordAdministrator(administrator);
    }

    //list of area
    @GetMapping("zones")
    public List<Area> zonesGet() {
        return areaService.getAreas();
    }

    //list of slotTimes
    @GetMapping("slots")
    public List<SlotTime> slotsGet() {
    return slotTimeService.getSlotTimes();
    }

    // add zone
    @PostMapping("zones/{nom}")
    public Area zonesPost(@PathVariable String nom) {
        return areaService.addArea(nom);
    }

    // delete zone
    @DeleteMapping("zones/{id}")
    public boolean zoneDelete(@PathVariable Long id) {
        return areaService.deleteArea(id);
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    @CrossOrigin(origins = "*")
    @PostMapping("login/{email}/{password}")
    public User getPasswordByEmail(@PathVariable String email, @PathVariable String password) {
     User user = usersService.getUser(email, password);
        System.out.println("connexion de"+email);
        return user;
    }


    /**
     * Ajouter une annonce
     * @param advert
     * @return
     */
    @CrossOrigin(origins = "*")
    @PostMapping(value = "advert/{id}", consumes = {"*/*"})
    public Advert addAdvert(@RequestBody Advert advert, @PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);

        advert.setDateCreate(new Date());
        advert.setCustomer(customer);
        return advertService.recordAdvert(advert);
    }

    //add user
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
     * Récupérer les annonces d'un user
     * @param id
     * @return
     */
    @CrossOrigin(origins = "*")
    @GetMapping("customer/{id}/adverts")
    public List<Advert> getAdvertsByCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
        return advertService.getAdvertsByCustomer(customer);

    }

    /**
     * Récupérer une annonce par son id
     * @param id
     * @return
     */
    @GetMapping("advert/{id}")
    public Advert getAdvertById(@PathVariable Long id){
        return advertService.getAdvert(id);
    }

}