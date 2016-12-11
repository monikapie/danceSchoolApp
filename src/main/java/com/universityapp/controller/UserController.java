package com.universityapp.controller;

import com.universityapp.model.UserEntity;
import com.universityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by pietyszukm on 11.12.2016.
 */
@RestController
@RequestMapping("/users")
public class UserController{
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<UserEntity> getAllTeams(){
        return userService.getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public UserEntity getTeamWithId(@PathVariable Long id){
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addTeam(@RequestBody UserEntity input){
        userService.save(input);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateTeam(@PathVariable(value = "id") Long id, @RequestBody UserEntity input){
        userService.save(input);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteTeam(@PathVariable(value = "id") Long id){
        UserEntity userEntity = userService.findById(id);
        userService.delete(userEntity);
    }
}
