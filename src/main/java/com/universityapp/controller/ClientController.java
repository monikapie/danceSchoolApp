package com.universityapp.controller;

import com.universityapp.model.ClientEntity;
import com.universityapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Monika on 10/24/2016.
 */
@RestController
@RequestMapping("/clients")
public class ClientController{
    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<ClientEntity> getAllClients(){
        return clientService.getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ClientEntity getClientWithId(@PathVariable Long id){
        return clientService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public ClientEntity findClientWithName(@RequestParam(value = "name") String name){
        return clientService.findClientByName(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addClient(@RequestBody ClientEntity input){
        clientService.save(input);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateClient(@RequestBody ClientEntity input){
        clientService.save(input);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteClient(@PathVariable(value = "id") Long id){
        ClientEntity clientEntity = clientService.findById(id);
        clientService.delete(clientEntity);
    }
}
