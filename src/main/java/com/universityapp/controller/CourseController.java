package com.universityapp.controller;

import com.universityapp.model.CourseEntity;
import com.universityapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Monika on 11/13/2016.
 */
@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<CourseEntity> getAllClients(){
        return courseService.getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public CourseEntity getClientWithId(@PathVariable Long id){
        return courseService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addClient(@RequestBody CourseEntity input){
        courseService.save(input);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateClient(@PathVariable(value = "id") Long id, @RequestBody CourseEntity input){
        courseService.save(input);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteClient(@PathVariable(value = "id") Long id){
        CourseEntity clientEntity = courseService.findById(id);
        courseService.delete(clientEntity);
    }
}
