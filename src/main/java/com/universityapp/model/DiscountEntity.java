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
@Table(name = "Discount")
/**
 * Discount entity class
 * Discount can be assigned to many cards of different clients.
 * */
public class DiscountEntity extends AbstractEntity{
    @Column
    private String type;

    @Column
    @NotNull
    private Integer value;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "discountId")
    private Set<CardEntity> cards;
}
