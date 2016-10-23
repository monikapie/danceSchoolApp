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
public class CourseEntity extends AbstractEntity{
    @Column
    @NotNull
    private String type;

    @Column
    private Long cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    @NotNull
    private EmployeeEntity trainer;

    @OneToMany(mappedBy = "course")
    private Set<TeamEntity> teams = new HashSet<>();

}
