package com.universityapp.service.serviceImpl;

import com.universityapp.model.ClientEntity;
import com.universityapp.repository.ClientRepository;
import com.universityapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Monika on 10/23/2016.
 */
@Service
public class ClientServiceImpl extends AbstractService<ClientEntity> implements ClientService{
    ClientRepository repository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        super(clientRepository);
        this.repository = clientRepository;
    }

    @Override
    public ClientEntity findClientByName(String name) {
        return repository.findClientByName(name);
    }
}

