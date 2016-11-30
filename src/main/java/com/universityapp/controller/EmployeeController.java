package com.universityapp.controller;

import com.universityapp.model.EmployeeEntity;
import com.universityapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Monika on 11/13/2016.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<EmployeeEntity> getAllEmployees(){
        return employeeService.getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public EmployeeEntity getEmployeeWithId(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addEmployee(@RequestBody EmployeeEntity input){
        employeeService.save(input);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateEmployee(@PathVariable(value = "id") Long id, @RequestBody EmployeeEntity input){
        employeeService.save(input);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteClient(@PathVariable(value = "id") Long id){
        EmployeeEntity clientEntity = employeeService.findById(id);
        employeeService.delete(clientEntity);
    }
}
