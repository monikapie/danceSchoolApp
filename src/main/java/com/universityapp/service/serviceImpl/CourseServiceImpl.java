package com.universityapp.service.serviceImpl;

import com.universityapp.model.CourseEntity;
import com.universityapp.repository.CourseRepository;
import com.universityapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Monika on 10/23/2016.
 */
@Service
public class CourseServiceImpl extends AbstractService<CourseEntity> implements CourseService{
    CourseRepository repository;

    @Autowired
    public CourseServiceImpl(CourseRepository repository){
        super(repository);
        this.repository = repository;
    }
}
