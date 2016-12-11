package com.universityapp.service.serviceImpl;

import com.universityapp.model.ClassroomEntity;
import com.universityapp.repository.ClassroomRepository;
import com.universityapp.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Monika on 10/23/2016.
 */
@Service
public class ClassroomServiceImpl extends AbstractService<ClassroomEntity> implements ClassroomService{
    private ClassroomRepository repository;

    @Autowired
    public ClassroomServiceImpl(ClassroomRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
