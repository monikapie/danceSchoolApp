package com.universityapp.service.serviceImpl;

import com.universityapp.model.ClientEntity;
import com.universityapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Monika on 10/23/2016.
 */
@Service
public class ClientServiceImpl extends AbstractService<ClientEntity>{
    ClientRepository repository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        super(clientRepository);
        this.repository = clientRepository;
    }
}

