package com.universityapp.service.serviceImpl;

import com.universityapp.model.CardEntity;
import com.universityapp.repository.CardRepository;
import com.universityapp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Monika on 10/23/2016.
 */
@Service
public class CardServiceImpl extends AbstractService<CardEntity> implements CardService{
    private CardRepository repository;

    @Autowired
    public CardServiceImpl(CardRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
