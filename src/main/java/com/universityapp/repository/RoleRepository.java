package com.universityapp.repository;

import com.universityapp.enums.RoleType;
import com.universityapp.model.RoleEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by pietyszukm on 11.12.2016.
 */
@Repository
public interface RoleRepository extends AbstractRepository<RoleEntity> {

    RoleEntity findByRole(RoleType roleType);
}
