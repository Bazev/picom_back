package fr.businesscase.eb.picom.controller;


import fr.businesscase.eb.picom.business.*;
import fr.businesscase.eb.picom.service.*;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class InitController {

    private final UsersService usersService;
    private final AreaService areaService;
    private final ArretService arretService;
    private final AdvertService advertService;
    private final SlotTimeService slotTimeService;
    private static final Random random = new Random();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public InitController(UsersService usersService, AreaService areaService, ArretService arretService, AdvertService advertService, SlotTimeService slotTimeService) {
        this.usersService = usersService;
        this.areaService = areaService;
        this.arretService = arretService;
        this.advertService = advertService;
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
                for(int j = 1; j <=5; j++) {
                    Arret arret = new Arret();
                    arret.setName("arret"+j);
                arretService.ajouterArret(arret.getName(), area.getId());
                }
            }
        }

        /*
        Ajout des tranches horaires
         */
        if (slotTimeService.getSlotTimes().isEmpty()) {
            for (int i = 6; i <= 20; i++ ) {
                SlotTime slotTime = new SlotTime();
                slotTime.setStart(i);
                slotTimeService.recordSlotTime(slotTime);
            }
        }

        /*
        Ajout de 15 clients
         */
        if (usersService.getUsers().isEmpty()) {
            for (int i =1; i <= 15; i++) {
                Customer customer = new Customer();
                customer.setLastName("Doe"+i);
                customer.setFirstName("John"+i);
                customer.setEmail("JohnDoe"+i+"@domaine.fr");
                customer.setPassword("password+"+i*5);
                usersService.recordCustomer(customer);

                for (int j=1; j <= 4; j++) {

                    List<SlotTime> slotTimeList = new ArrayList<>();
                    slotTimeList.add(slotTimeService.getSlotTime(10));
                    slotTimeList.add(slotTimeService.getSlotTime(11));
                    slotTimeList.add(slotTimeService.getSlotTime(12));
                    List<Area> areaList = new ArrayList<>();
                    areaList.add(areaService.getArea("Zone1"));
                    areaList.add(areaService.getArea("Zone2"));
                    areaList.add(areaService.getArea("Zone3"));
                }
            }
        }
    }
}
