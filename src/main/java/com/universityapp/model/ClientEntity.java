package com.universityapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
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
@Table(name = "Client")
/**
 * Client entity class
 * Client can be member of many dance teams and can have only one membership card.
 * */
public class ClientEntity extends AbstractEntity{
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
    private String email;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private CardEntity card;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "clients")
    private Set<TeamEntity> teams = new HashSet<>();

    public ClientEntity(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public ClientEntity(String name, String surname, Long phone, String email, Date birthDate, CardEntity card) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
        this.card = card;
    }
}
