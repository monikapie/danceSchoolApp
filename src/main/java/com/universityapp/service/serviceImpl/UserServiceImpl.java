package com.universityapp.service.serviceImpl;

import com.universityapp.model.UserEntity;
import com.universityapp.repository.UserRepository;
import com.universityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Monika on 11/1/2016.
 */
@Service
public class UserServiceImpl extends AbstractService<UserEntity> implements UserService{
    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object response = authentication.getPrincipal();
        return response instanceof UserEntity ? (UserEntity) response : null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getCurrentUserAuthorities() {
        return getCurrentUser().getAuthorities();
    }


    @Override
    public boolean doesUserExist(String username) {
        UserEntity user = repository.findByUsername(username);
        return user != null;
    }
}
