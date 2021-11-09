package fr.businesscase.eb.picom.Repository;

import fr.businesscase.eb.picom.business.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<Administrator, Long> {
}