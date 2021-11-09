package fr.businesscase.eb.picom.Repository;

import fr.businesscase.eb.picom.business.Advert;
import fr.businesscase.eb.picom.business.Customer;
import fr.businesscase.eb.picom.business.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, Long> {

    Page<Advert> findByIntituleContaining(String filtre, Pageable pageable);

    Page<Advert> findByIntituleContainingAndIdNot(User userEnSession, String filtre, Pageable pageable);

    Page<Advert> findByCustomer(Pageable pageable, Customer customer);

    List<Advert> findByCustomer(Customer customer);

}
