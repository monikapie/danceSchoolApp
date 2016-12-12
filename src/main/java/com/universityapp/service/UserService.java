package com.universityapp.service;

import com.universityapp.model.UserEntity;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by Monika on 10/24/2016.
 */
public interface UserService extends ServiceInterface<UserEntity> {
    public UserEntity findByUsername(String username);
    UserEntity getCurrentUser();
    Collection<? extends GrantedAuthority> getCurrentUserAuthorities();
    boolean doesUserExist(String username);
}
