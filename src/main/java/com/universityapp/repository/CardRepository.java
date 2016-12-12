package com.universityapp.repository;

import com.universityapp.model.CardEntity;
import com.universityapp.model.ClientEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Monika on 10/23/2016.
 */
@Repository
public interface CardRepository extends AbstractRepository<CardEntity>{
    public List<CardEntity> findByClientId(Long id);

}
