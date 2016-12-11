package com.universityapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Monika on 10/22/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Course")
/**
 * Course entity class.
 * Course can be connected with one employee - trainer
 * and can be assigned to many teams(which are on different
 * dance class level
 * */
public class CourseEntity extends AbstractEntity{
    @Column
    @NotNull
    private String type;

    @Column
    private Long cost;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "trainer_id")
//    @NotNull
//    private EmployeeEntity trainer;

    @Column(name = "trainer_id")
    private Long trainerId;

    @OneToMany(mappedBy = "courseId")
    private Set<TeamEntity> teams = new HashSet<>();

    public CourseEntity(String type, Long cost, Long trainer){
        this.type = type;
        this.cost = cost;
        this.trainerId = trainer;
    }
}
