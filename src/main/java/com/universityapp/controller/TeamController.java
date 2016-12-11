package com.universityapp.controller;

import com.universityapp.model.TeamEntity;
import com.universityapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/teams")
public class TeamController{
    @Autowired
    private TeamService teamService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<TeamEntity> getAllTeams(){
        return teamService.getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public TeamEntity getTeamWithId(@PathVariable Long id){
        return teamService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addTeam(@RequestBody TeamEntity input){
        teamService.save(input);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateTeam(@PathVariable(value = "id") Long id, @RequestBody TeamEntity input){
        teamService.save(input);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteTeam(@PathVariable(value = "id") Long id){
        TeamEntity planEntity = teamService.findById(id);
        teamService.delete(planEntity);
    }
}
