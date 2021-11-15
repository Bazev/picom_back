package fr.businesscase.eb.picom.controller;

import fr.businesscase.eb.picom.business.*;
import fr.businesscase.eb.picom.service.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
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
    @GetMapping("ws/zones")
    public List<Area> zonesGet() {
        return areaService.getAreas();
    }

    // add zone
    @PostMapping("ws/zones/{nom}")
    public Area zonesPost(@PathVariable String nom) {
        Area area = areaService.addArea(nom);
        return area;
    }

    // delete zone
    @DeleteMapping("ws/zones/{id}")
    public boolean zoneDelete(@PathVariable Long id) {
        return areaService.deleteArea(id);
    }

    //connexion
//    @CrossOrigin(origins = "*")
//    @PostMapping("ws/login/{email}/{password}")
//    boolean getPasswordByEmail(@PathVariable String email, @PathVariable String password) {
//         usersService.checkEmailAndPassword(email, password);
//        System.out.println("connexion de"+email);
//         return true;
//    }

    @CrossOrigin(origins = "*")
    @PostMapping("ws/login/{email}/{password}")
    public User getPasswordByEmail(@PathVariable String email, @PathVariable String password) {
     User user = usersService.getUser(email, password);
        System.out.println("connexion de"+email);
        return user;
    }

    //add advert Picture
    @PostMapping("ws/advertPicture/dateCreate/{dateCreate}/dateStart/{dateStart}/dateEnd/{dateEnd}/customer/{customerId}/area/{areaId}/houres/{houresId}")
    public AdvertImage addAnnonce(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateCreate, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateStart,
                                  @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateEnd, @PathVariable long customerId, @PathVariable long areaId,
                                  @PathVariable long houresId) {
        AdvertImage annonceImage = new AdvertImage();
        annonceImage.setDateCreate(dateCreate);
        annonceImage.setDateStart(dateStart);
        annonceImage.setDateEnd(dateEnd);
        Customer customer = customerService.getCustomer(customerId);
        annonceImage.setCustomer(customer);
        List<Area> areasAnnonceHtml = new ArrayList<>();
        areasAnnonceHtml.add(areaService.getArea(areaId));
        annonceImage.setAreas(areasAnnonceHtml);
        List<SlotTime> houresAnnonceHtml = new ArrayList<>();
        houresAnnonceHtml.add(slotTimeService.getHoure(houresId));
        annonceImage.setSlotTimes(houresAnnonceHtml);
        return advertService.recordAdvertPicture(annonceImage);
    }

    //add advert Html
    @PostMapping("ws/advertHtml/dateCreate/{dateCreate}/dateStart/{dateStart}/dateEnd/{dateEnd}/customer/{customerId}/area/{areaId}/houres/{houresId}/content/{content}")
    public AdvertHtml addAvertHtml(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateCreate, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateStart,
                                   @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateEnd, @PathVariable long customerId, @PathVariable long areaId,
                                   @PathVariable long houresId, @PathVariable String content) {
        AdvertHtml annonceHtml = new AdvertHtml();
        annonceHtml.setDateCreate(dateCreate);
        annonceHtml.setDateStart(dateStart);
        annonceHtml.setDateEnd(dateEnd);
        Customer customer = customerService.getCustomer(customerId);
        annonceHtml.setCustomer(customer);
        List<Area> areasAnnonceHtml = new ArrayList<>();
        areasAnnonceHtml.add(areaService.getArea(areaId));
        annonceHtml.setAreas(areasAnnonceHtml);
        List<SlotTime> houresAnnoncePicture = new ArrayList<>();
        houresAnnoncePicture.add(slotTimeService.getHoure(houresId));
        annonceHtml.setSlotTimes(houresAnnoncePicture);
        annonceHtml.setContenu(content);
        return advertService.recordAdvertHtml(annonceHtml);
    }

    //add user
    @PostMapping("ws/addCustomer/{lastname}/{firstname}/{email}/{password}/{numtel}")
    public Customer addCustomer(@PathVariable String lastname, @PathVariable String firstname, @PathVariable String email, @PathVariable String password) {
        Customer customer = new Customer();
        customer.setLastName(lastname);
        customer.setFirstName(firstname);
        customer.setEmail(email);
        customer.setPassword(password);
        return usersService.recordCustomer(customer);
    }

    // get adberts by customer
    @GetMapping("ws/customer/{id}/adverts")
    public List<Advert> getAdvertsByCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
        return advertService.getAdvertsByCustomer(customer);

    }

}