package com.universityapp.service.serviceImpl;

import com.universityapp.model.DiscountEntity;
import com.universityapp.repository.DiscountRepository;
import com.universityapp.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Monika on 10/23/2016.
 */
@Service
public class DiscountServiceImpl extends AbstractService<DiscountEntity> implements DiscountService{
    DiscountRepository repository;

    @Autowired
    public DiscountServiceImpl(DiscountRepository repository){
        super(repository);
        this.repository = repository;
    }
}
