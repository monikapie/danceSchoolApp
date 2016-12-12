package com.universityapp.service;

import com.universityapp.model.CardEntity;
import com.universityapp.model.ClientEntity;

import java.util.List;

/**
 * Created by Monika on 10/23/2016.
 */
public interface CardService extends ServiceInterface<CardEntity>{
    public List<CardEntity> findByClientId(Long client);
}
