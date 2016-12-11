package com.universityapp.service.serviceImpl;

import com.universityapp.model.ContractEntity;
import com.universityapp.repository.ContractRepository;
import com.universityapp.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Monika on 10/23/2016.
 */
@Service
public class ContractServiceImpl extends AbstractService<ContractEntity> implements ContractService {
    ContractRepository repository;

    @Autowired
    public ContractServiceImpl(ContractRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<ContractEntity> findByEmployeeId(Long id) {
        return repository.findByEmployeeId(id);
    }
}
