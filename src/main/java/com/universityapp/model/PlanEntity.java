package com.universityapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Monika on 10/22/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Plan")
/**
 * Plan entity class.
 * Plan record can be connected with one classroom
 * and can be assigned to one team.
 * */
public class PlanEntity extends AbstractEntity{

    @Column(name = "day_of_week")
    @NotNull
    private String dayOfWeek;

    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    @NotNull
    private Date startTime;

    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    @NotNull
    private Date endTime;

    @Column(name = "classroom_id")
    private Long classroomId;

    @Column(name = "team_id")
    private Long teamId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "classroom_id", nullable = false)
//    private ClassroomEntity classroom;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "team_id", nullable = false)
//    private TeamEntity team;
}
