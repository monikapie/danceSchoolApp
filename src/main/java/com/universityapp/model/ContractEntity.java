package com.universityapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.DateType;

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
public class ContractEntity extends AbstractEntity{
    @Column
    private String type;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    @NotNull
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column
    private Long salary;

    @Column
    private String position;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contract")
    private Set<EmployeeEntity> employees;
}
