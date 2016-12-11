package com.universityapp.controller;

import com.universityapp.model.ContractEntity;
import com.universityapp.model.TeamEntity;
import com.universityapp.service.ContractService;
import com.universityapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by pietyszukm on 11.12.2016.
 */
@RestController
@RequestMapping("/contracts")
public class ContractController{
    @Autowired
    private ContractService contractService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<ContractEntity> getAllContracts(){
        return contractService.getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employee/{id}")
    public List<ContractEntity> getContractByEmployeeId(@PathVariable Long id){
        return contractService.findByEmployeeId(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ContractEntity getContractWithId(@PathVariable Long id){
        return contractService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addContract(@RequestBody ContractEntity input){
        contractService.save(input);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateContract(@PathVariable(value = "id") Long id, @RequestBody ContractEntity input){
        contractService.save(input);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteContract(@PathVariable(value = "id") Long id){
        ContractEntity contractEntity = contractService.findById(id);
        contractService.delete(contractEntity);
    }
}
