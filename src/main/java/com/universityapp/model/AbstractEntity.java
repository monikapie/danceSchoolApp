package com.universityapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Monika on 10/23/2016.
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
/*
* Abstract class with id  generator.
* **/
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long Id;
}
