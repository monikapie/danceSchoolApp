package com.universityapp.service.serviceImpl;

import com.universityapp.model.PlanEntity;
import com.universityapp.repository.PlanRepository;
import com.universityapp.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Monika on 10/23/2016.
 */
@Service
public class PlanServiceImpl extends AbstractService<PlanEntity> implements PlanService{
    PlanRepository repository;

    @Autowired
    public PlanServiceImpl(PlanRepository repository){
        super(repository);
        this.repository = repository;
    }
}
