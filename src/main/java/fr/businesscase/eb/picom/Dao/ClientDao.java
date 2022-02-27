package fr.businesscase.eb.picom.Dao;

import fr.businesscase.eb.picom.business.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Long> {
}
