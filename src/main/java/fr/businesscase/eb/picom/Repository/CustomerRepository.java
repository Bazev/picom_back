package fr.businesscase.eb.picom.Repository;

import fr.businesscase.eb.picom.business.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
