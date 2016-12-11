package com.universityapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Monika on 10/23/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Team")
/**
 * Team entity class.
 * Team can consists of many members and can be connected only to one course.
 * */
public class TeamEntity extends AbstractEntity{
    @Column(name = "stage")
    @Length(max = 30)
    @NotNull
    private String stage;

    @Column(name = "course_id")
    private Long courseId;
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private CourseEntity course;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "group_client",
            joinColumns = {@JoinColumn(name = "group_id") },
            inverseJoinColumns = { @JoinColumn(name = "client_id") })
    private Set<ClientEntity> clients = new HashSet<>();

    @OneToMany(mappedBy = "teamId")
    private Set<PlanEntity> plans = new HashSet<>();
}
