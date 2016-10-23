package com.universityapp.service;

import com.universityapp.model.AbstractEntity;

import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by Monika on 10/23/2016.
 */
public interface ServiceInterface <T extends AbstractEntity>{
    public T save(@NotNull final T entity) ;
    public Collection<T> getList();
    public void delete(T entity);
    public T findById(Long id);
    public T update(T entity);
}
