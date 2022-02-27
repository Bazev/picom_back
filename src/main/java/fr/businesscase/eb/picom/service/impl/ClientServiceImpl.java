package fr.businesscase.eb.picom.service.impl;

import fr.businesscase.eb.picom.Dao.ClientDao;
import fr.businesscase.eb.picom.business.Client;
import fr.businesscase.eb.picom.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public Client getCustomer(Long id) {
        return clientDao.findById(id).orElse(null);
    }
}
