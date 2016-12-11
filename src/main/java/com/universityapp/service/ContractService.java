package com.universityapp.service;

import com.universityapp.model.ContractEntity;

import java.util.List;
import java.util.Set;

/**
 * Created by Monika on 10/23/2016.
 */

public interface ContractService extends ServiceInterface<ContractEntity>{
    public List<ContractEntity> findByEmployeeId(Long id);
}
