package fr.businesscase.eb.picom.service;

import fr.businesscase.eb.picom.business.Administrator;
import fr.businesscase.eb.picom.business.Customer;
import fr.businesscase.eb.picom.business.User;


import java.util.List;

public interface UsersService {

    Customer recordCustomer(Customer customer);
    Administrator recordAdministrator(Administrator administrator);

    User getUser(String email, String password);

    List<User> getUsers();

    User getUser(Long id);

    String getPasswordByEmail(String email);

    boolean checkEmailAndPassword(String email, String password);

}
