package fr.businesscase.eb.picom.service.impl;

import fr.businesscase.eb.picom.Repository.CustomerRepository;
import fr.businesscase.eb.picom.business.Customer;
import fr.businesscase.eb.picom.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
