package com.universityapp.repository;

import com.universityapp.model.UserEntity;

/**
 * Created by Monika on 11/1/2016.
 */
public interface UserRepository extends AbstractRepository<UserEntity>{
    public UserEntity findByUsername(String username);
}
