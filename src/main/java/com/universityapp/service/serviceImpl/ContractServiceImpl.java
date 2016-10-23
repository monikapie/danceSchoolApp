package com.universityapp.service.serviceImpl;

import com.universityapp.model.ContractEntity;
import com.universityapp.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Monika on 10/23/2016.
 */
public class ContractServiceImpl extends AbstractService<ContractEntity>{
    ContractRepository repository;

    @Autowired
    private ContractServiceImpl(ContractRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
