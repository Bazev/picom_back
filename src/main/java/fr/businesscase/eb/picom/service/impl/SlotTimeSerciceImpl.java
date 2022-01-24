package fr.businesscase.eb.picom.service.impl;

import fr.businesscase.eb.picom.Repository.SlotTimeRepository;
import fr.businesscase.eb.picom.business.SlotTime;
import fr.businesscase.eb.picom.service.SlotTimeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SlotTimeSerciceImpl implements SlotTimeService {

    private final SlotTimeRepository slotTimeRepository;

    public SlotTimeSerciceImpl(SlotTimeRepository slotTimeRepository) {
        this.slotTimeRepository = slotTimeRepository;
    }

    @Override
    public SlotTime addSlotTime(int debut) {
        return slotTimeRepository.save(new SlotTime(debut));
    }

    @Override
    public ArrayList<SlotTime> getSlotTimes() {
        return (ArrayList<SlotTime>) slotTimeRepository.findAll();
    }

    @Override
    public SlotTime getSlotTime(int debut) {
        return slotTimeRepository.findByStart(debut);
    }

    @Override
    public SlotTime getHoure(Long id) {
        return slotTimeRepository.getById(id);
    }

    @Override
    public SlotTime recordSlotTime(SlotTime slotTime) {
        return slotTimeRepository.save(slotTime);
    }
}
