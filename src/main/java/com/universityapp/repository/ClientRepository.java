package com.universityapp.repository;

import com.universityapp.model.ClientEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by Monika on 10/23/2016.
 */
@Repository
public interface ClientRepository extends AbstractRepository<ClientEntity>{
    public ClientEntity findClientByName(String name);
}
