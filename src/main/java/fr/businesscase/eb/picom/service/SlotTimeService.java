package fr.businesscase.eb.picom.service;

import fr.businesscase.eb.picom.business.SlotTime;

import java.util.List;

public interface SlotTimeService {

    SlotTime addSlotTime(int debut);

    List<SlotTime> getSlotTimes();

    SlotTime getSlotTime(int debut);

    SlotTime getHoure(Long id);


}
