package com.universityapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Monika on 10/22/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Classroom")
/**
 * Classroom entity class
 * Classroom can be assign to many plan record.
 * TODO create validation for plan record checking if room is not used at this time by another plan record.
 * */
public class ClassroomEntity extends AbstractEntity{

    @Column
    @NotNull
    private String name;

    @Column(name = "max_people")
    private Integer maxPeople;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classroom")
    private Set<PlanEntity> plans;
}
