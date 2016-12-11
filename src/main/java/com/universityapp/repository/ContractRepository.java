package com.universityapp.repository;

import com.universityapp.model.ContractEntity;
import com.universityapp.model.CourseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by Monika on 10/23/2016.
 */
@Repository
public interface ContractRepository  extends AbstractRepository<ContractEntity>{
    public List<ContractEntity> findByEmployeeId(Long id);
}
