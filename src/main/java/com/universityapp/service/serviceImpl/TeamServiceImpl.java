package com.universityapp.service.serviceImpl;

import com.universityapp.model.TeamEntity;
import com.universityapp.repository.TeamRepository;
import com.universityapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Monika on 10/23/2016.
 */
@Service
public class TeamServiceImpl extends AbstractService<TeamEntity> implements TeamService{
    TeamRepository repository;

    @Autowired
    public TeamServiceImpl(TeamRepository repository){
        super(repository);
        this.repository = repository;
    }
}
