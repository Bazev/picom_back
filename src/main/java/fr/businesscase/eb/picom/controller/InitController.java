package fr.businesscase.eb.picom.controller;


import fr.businesscase.eb.picom.business.*;
import fr.businesscase.eb.picom.service.*;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private static Random random = new Random();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

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
        Ajout de 20 zones si la liste des zones est vide
        et 5 arrets par zone
         */
        if (areaService.getAreas().isEmpty()) {
            for (int i = 1; i <= 20; i++) {
                Area area = new Area();
                area.setNom("Zone" + i);
                areaService.recordArea(area);
                for(int j = 1; j <=10; j++) {
                    arretService.ajouterArret("Arret"+j, area.getId());
                }
            }
        }

        /*
        Ajout des tranches horaires
         */
        if (slotTimeService.getSlotTimes().isEmpty()) {
            slotTimeService.addSlotTime(6);
            slotTimeService.addSlotTime(7);
            slotTimeService.addSlotTime(8);
            slotTimeService.addSlotTime(9);
            slotTimeService.addSlotTime(10);
            slotTimeService.addSlotTime(11);
            slotTimeService.addSlotTime(12);
            slotTimeService.addSlotTime(13);
            slotTimeService.addSlotTime(14);
            slotTimeService.addSlotTime(15);
            slotTimeService.addSlotTime(16);
            slotTimeService.addSlotTime(17);
            slotTimeService.addSlotTime(18);
            slotTimeService.addSlotTime(19);
            slotTimeService.addSlotTime(20);
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
                customer.setPassword("password"+random.nextInt(500));
                usersService.recordCustomer(customer);
                for (int j=1; j <= 4; j++) {
                    AdvertImage annonceImage = new AdvertImage();
                    annonceImage.setCustomer(customer);
                    try {
                        Date dateDebut = format.parse("2021-10-01");
                        Date dateFin = format.parse("2021-11-21");
                        annonceImage.setDateStart(dateDebut);
                        annonceImage.setDateEnd(dateFin);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    annonceImage.setContent("Intitule"+j);
                    List<SlotTime> slotTimeList = slotTimeService.getSlotTimes();
                    slotTimeList.add(slotTimeService.getSlotTime(10));
                    slotTimeList.add(slotTimeService.getSlotTime(11));
                    slotTimeList.add(slotTimeService.getSlotTime(12));
                    List<Area> areaList = areaService.getAreas();
                    areaList.add(areaService.getArea("zone1"));
                    areaList.add(areaService.getArea("zone4"));
                    areaList.add(areaService.getArea("zone7"));
                    annonceImage.setSlotTimes(slotTimeList);
                    annonceImage.setAreas(areaList);
                    advertService.recordAdvertPicture(annonceImage);
                }
            }
        }

    }
}
