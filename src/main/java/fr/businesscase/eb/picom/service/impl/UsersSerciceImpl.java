package fr.businesscase.eb.picom.service.impl;

import fr.businesscase.eb.picom.Repository.UsersRepository;
import fr.businesscase.eb.picom.business.Administrator;
import fr.businesscase.eb.picom.business.Customer;
import fr.businesscase.eb.picom.business.User;
import fr.businesscase.eb.picom.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersSerciceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public UsersSerciceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public Customer recordCustomer(Customer customer) {
        return usersRepository.save(customer);
    }

    @Override
    public Administrator recordAdministrator(Administrator administrator) {
        return usersRepository.save(administrator);
    }

    @Override
    public User getUser(String email, String password) {
        return usersRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return usersRepository.findById(id).orElse(null);
    }


}