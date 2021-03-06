package fr.businesscase.eb.picom.service.impl;

import fr.businesscase.eb.picom.Repository.AdvertRepository;
import fr.businesscase.eb.picom.business.*;
import fr.businesscase.eb.picom.service.AdvertService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;

    public AdvertServiceImpl(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @Override
    public List<Advert> getAdverts() {
        return advertRepository.findAll();
    }

    @Override
    public List<Advert> getAdvertsByCustomer(Customer customer) {
        return advertRepository.findByCustomer(customer);
    }

    @Override
    public Advert recordAdvert(Advert advert) {
        return advertRepository.save(advert);
    }

    @Override
    public Page<Advert> getAdverts(String filtre, Pageable pageable) {
        return advertRepository.findByTitleContaining(filtre, pageable);
    }

    @Override
    public Page<Advert> getAdverts(User userEnSession, String filtre, Pageable pageable) {
        return advertRepository.findByTitleContainingAndIdNot(userEnSession, filtre, pageable);
    }

    @Override
    public Object getAdverts(Pageable pageable, Customer customer) {
        return advertRepository.findByCustomer(pageable, customer);
    }

    @Override
    public Page<Advert> getAdverts(Pageable pageable) {
        return advertRepository.findAll(pageable);
    }

    @Override
    public Advert getAdvert(Long id) {
        return advertRepository.findById(id).orElse(null);
    }

    @Override
    public Advert modifierContenuAnnonce(Advert advert, String contenu) {
        advert.setContenu(contenu);
        return advertRepository.save(advert);
    }

}
