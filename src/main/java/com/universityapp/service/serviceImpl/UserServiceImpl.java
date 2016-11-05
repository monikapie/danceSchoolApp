package com.universityapp.service.serviceImpl;

import com.universityapp.model.UserEntity;
import com.universityapp.repository.UserRepository;
import com.universityapp.service.UserService;

/**
 * Created by Monika on 11/1/2016.
 */
public class UserServiceImpl extends AbstractService<UserEntity> implements UserService{
    UserRepository repository;
    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return repository.findByUsername(username);
    }
}