package com.universityapp.repository;

import com.universityapp.model.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by Monika on 11/1/2016.
 */
@Repository
public interface UserRepository extends AbstractRepository<UserEntity>{
    public UserEntity findByUsername(String username);
}
