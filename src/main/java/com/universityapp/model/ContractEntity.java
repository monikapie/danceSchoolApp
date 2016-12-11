package com.universityapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * Created by Monika on 10/22/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Contract")
/**
 * Contract entity class
 * Contract can be connected with many employees
 * for example in situation when many employees
 * sign agreement at the same time.
 * */
public class ContractEntity extends AbstractEntity{
    @Column
    private String type;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    @NotNull
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @Column
    private Long salary;

    @Column
    private String position;

    @Column(name = "employee_id")
    private Long employeeId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "employee_id")
//    private EmployeeEntity employee;

}
