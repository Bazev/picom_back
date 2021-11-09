package fr.businesscase.eb.picom.Repository;

import fr.businesscase.eb.picom.business.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface UsersRepository extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);
}