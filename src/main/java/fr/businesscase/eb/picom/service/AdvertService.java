package fr.businesscase.eb.picom.service;

import fr.businesscase.eb.picom.business.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface AdvertService {

    List<Advert> getAdverts();

    List<Advert> getAdvertsByCustomer(Customer customer);

    AdvertImage recordAdvertPicture(AdvertImage annonceImage);

    AdvertHtml recordAdvertHtml(AdvertHtml annonceHtml);

    Page<Advert> getAdverts(String filtre, Pageable pageable);

    Page<Advert> getAdverts(User userEnSession, String filtre, Pageable pageable);

    Object getAdverts(Pageable pageable, Customer customer);

    Page<Advert> getAdverts(Pageable pageable);

    Advert getAdvert(Long id);
}
