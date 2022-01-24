package fr.businesscase.eb.picom.service;

import fr.businesscase.eb.picom.business.Area;

import java.util.ArrayList;
import java.util.List;

public interface AreaService {

    Area addArea(String nom);
    Area getArea(Long id);
    Area getArea(String nom);
    Area recordArea(Area area);
    ArrayList<Area> getAreas();
    boolean deleteArea(Long id);
}
