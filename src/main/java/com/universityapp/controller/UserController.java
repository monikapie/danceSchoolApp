package com.universityapp.controller;

import com.universityapp.enums.RoleType;
import com.universityapp.model.UserEntity;
import com.universityapp.repository.RoleRepository;
import com.universityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by pietyszukm on 11.12.2016.
 */
@RestController
@RequestMapping("/users")
public class UserController{
    private UserService service;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    public UserController(UserService service) {
        super();
        this.service = service;
    }

    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    public UserEntity getCurrentlyLoggedUser(){
        return service.getCurrentUser();
    }

    @RequestMapping(value = "/currentUser/authorities")
    public Collection<? extends GrantedAuthority> getLoggedUserAuthorities(){
        return service.getCurrentUserAuthorities();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserEntity registerNewUser(@RequestBody UserEntity user) {
        boolean doesUserExist = service.doesUserExist(user.getUsername());
        if(!doesUserExist) {
            UserEntity newUser = new UserEntity(user.getUsername(), encoder.encode(user.getPassword()), true);
            newUser.getRoles().add(roleRepository.findByRole(RoleType.USER));
            service.save(newUser);

            return newUser;
        } else {
            return null;
        }
    }
}
