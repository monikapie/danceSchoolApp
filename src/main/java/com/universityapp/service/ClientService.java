package com.universityapp.service;

import com.universityapp.model.ClientEntity;

/**
 * Created by Monika on 10/23/2016.
 */
public interface ClientService extends ServiceInterface<ClientEntity>{
    public ClientEntity findClientByName(String name);
}
