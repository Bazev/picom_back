package fr.businesscase.eb.picom.controller;


import fr.businesscase.eb.picom.business.Area;
import fr.businesscase.eb.picom.business.Arret;
import fr.businesscase.eb.picom.business.Customer;
import fr.businesscase.eb.picom.business.SlotTime;
import fr.businesscase.eb.picom.service.*;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;

@Controller
public class InitController {

    private final UsersService usersService;
    private final AreaService areaService;
    private final ArretService arretService;

    private final SlotTimeService slotTimeService;
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public InitController(UsersService usersService, AreaService areaService, ArretService arretService, AdvertService advertService, SlotTimeService slotTimeService) {
        this.usersService = usersService;
        this.areaService = areaService;
        this.arretService = arretService;
        this.slotTimeService = slotTimeService;
    }

    @PostConstruct
    private void init() {
        /*
        Ajout de 10 zones si la liste des zones est vide
        et 5 arrets par zone
         */
        if (areaService.getAreas().isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                Area area = new Area();
                area.setName("Zone" + i);
                areaService.recordArea(area);
                for (int j = 1; j <= 5; j++) {
                    Arret arret = new Arret();
                    arret.setName("arret" + j);
                    arretService.ajouterArret(arret.getName(), area.getId());
                }
            }
        }

        /*
        Ajout des tranches horaires
         */
        if (slotTimeService.getSlotTimes().isEmpty()) {
            for (int i = 6; i <= 20; i++) {
                SlotTime slotTime = new SlotTime();
                slotTime.setStart(i);
                slotTimeService.recordSlotTime(slotTime);
            }
        }

        /*
        Ajout de 15 clients
         */
        if (usersService.getUsers().isEmpty()) {
            for (int i = 1; i <= 15; i++) {
                Customer customer = new Customer();
                customer.setLastName("Doe" + i);
                customer.setFirstName("John" + i);
                customer.setEmail("JohnDoe" + i + "@domaine.fr");
                customer.setPassword("password+" + i * 5);
                usersService.recordCustomer(customer);
            }
        }

    }
}
