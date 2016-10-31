package com.universityapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

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
@Table(name = "Employee")
/**
 * Empolyee entity class
 * Employee can lead many courses and is connected to only one contract.
 * */
public class EmployeeEntity extends AbstractEntity{
    @Column(name = "id_supervisor")
    private Long idSupervisor;

    @Column
    @NotNull
    @Length(max = 30)
    private String name;

    @Column
    @NotNull
    @Length(max = 50)
    private String surname;

    @Column
    private Long phone;

    @Column
    @NotNull
    @Length(max = 30)
    private String position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private ContractEntity contract;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer")
    private Set<CourseEntity> courses;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public EmployeeEntity(String name, String surname, String position){
        this.name = name;
        this.surname = surname;
        this.position = position;
    }
}
