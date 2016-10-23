package com.universityapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Classroom")
/**
 * Created by Monika on 10/22/2016.
 */
public class ClassroomEntity extends AbstractEntity{

    @Column
    @NotNull
    private String name;

    @Column(name = "max_people")
    private Integer maxPeople;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classroom")
    private Set<PlanEntity> plans;
}
