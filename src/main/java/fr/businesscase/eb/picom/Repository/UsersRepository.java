package fr.businesscase.eb.picom.Repository;

import fr.businesscase.eb.picom.business.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users",path = "users")
public interface UsersRepository extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);

    @Query("SELECT u.password FROM User u WHERE u.email =:email ")
    String findPasswordByEmail(@Param("email") String email);
}