package com.universityapp.repository;

import com.universityapp.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Monika on 10/23/2016.
 */
public interface AbstractRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {
}
