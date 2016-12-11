package com.universityapp.controller;

import com.universityapp.model.PlanEntity;
import com.universityapp.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by pietyszukm on 10.12.2016.
 */
@RestController
@RequestMapping("/plans")
public class PlanController{
    @Autowired
    private PlanService planService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<PlanEntity> getAllPlans(){
        return planService.getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public PlanEntity getPlanWithId(@PathVariable Long id){
        return planService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addPlan(@RequestBody PlanEntity input){
        planService.save(input);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updatePlan(@PathVariable(value = "id") Long id, @RequestBody PlanEntity input){
        planService.save(input);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deletePlan(@PathVariable(value = "id") Long id){
        PlanEntity planEntity = planService.findById(id);
        planService.delete(planEntity);
    }
}
