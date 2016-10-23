package com.universityapp.service.serviceImpl;

import com.universityapp.model.EmployeeEntity;
import com.universityapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Monika on 10/23/2016.
 */
@Service
public class EmployeeServiceImpl extends AbstractService<EmployeeEntity>{
    EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository){
        super(repository);
        this.repository = repository;
    }

}
