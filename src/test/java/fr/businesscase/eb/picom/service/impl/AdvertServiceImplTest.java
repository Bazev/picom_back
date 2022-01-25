package fr.businesscase.eb.picom.service.impl;

import fr.businesscase.eb.picom.business.Advert;
import fr.businesscase.eb.picom.business.Area;
import fr.businesscase.eb.picom.business.Customer;
import fr.businesscase.eb.picom.business.SlotTime;
import fr.businesscase.eb.picom.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class AdvertServiceImplTest {

    private UserServiceImpl userService;

    private SlotTimeServiceImpl slotTimeService;

    private AreaServiceImpl areaService;

    private AdvertServiceImpl advertService;

    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    @Test
    void getAdvertsByCustomer() {
    }

    @Test
    void recordAdvert() {
        Customer customer = new Customer();
        customer.setLastName("Doe");
        customer.setFirstName("John");
        customer.setEmail("JohnDoe@domaine.fr");
        customer.setPassword("password+");
        userService.recordCustomer(customer);
        Advert advert = new Advert();
        advert.setCustomer(customer);
        advert.setCustomer(customer);
        try {
            Date dateDebut = format.parse("01-10-2021");
            Date dateFin = format.parse("21-11-2021");
            advert.setDateStart(dateDebut);
            advert.setDateEnd(dateFin);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        advert.setTitle("Plomberie chauffage");
        List<SlotTime> slotTimeList = new ArrayList<>();
        slotTimeList.add(slotTimeService.getSlotTime(10));
        slotTimeList.add(slotTimeService.getSlotTime(11));
        slotTimeList.add(slotTimeService.getSlotTime(12));
        advert.setSlotTimes(slotTimeList);
        List<Area> areaList = new ArrayList<>();
        areaList.add(areaService.getArea("Zone1"));
        areaList.add(areaService.getArea("Zone2"));
        areaList.add(areaService.getArea("Zone3"));
        advert.setAreas(areaList);

        advertService.recordAdvert(advert);

        System.out.println(advert);
    }

    @Test
    void getAdverts() {
    }
}