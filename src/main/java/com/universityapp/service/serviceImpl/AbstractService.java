package com.universityapp.service.serviceImpl;

import com.universityapp.model.AbstractEntity;
import com.universityapp.repository.AbstractRepository;
import com.universityapp.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Monika on 10/23/2016.
 */
public class AbstractService <T extends AbstractEntity> implements ServiceInterface<T> {
    private final AbstractRepository<T> repository;

    @Autowired
    public AbstractService(final AbstractRepository<T> repository) {
        this.repository = repository;
    }

    @Transactional
    public T save(T entity) {
        return repository.save(entity);
    }

    @Transactional
    public Collection<T> getList() {
        return repository.findAll();
    }

    @Transactional
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Transactional
    public void deleteAll() {
        repository.deleteAll();
    }

    @Transactional
    public T findById(Long id) {
        return repository.findOne(id);
    }

    @Transactional
    public T update(T entity) {
        return repository.save(entity);
    }
}

