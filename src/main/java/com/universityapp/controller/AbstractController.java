package com.universityapp.controller;

import com.universityapp.model.AbstractEntity;
import com.universityapp.service.serviceImpl.AbstractService;

/**
 * Created by Monika on 10/24/2016.
 */
public abstract class AbstractController<T extends AbstractEntity> {

    private AbstractService<T> service;

    public AbstractController(AbstractService<T> service) {
        this.service = service;
    }
}
