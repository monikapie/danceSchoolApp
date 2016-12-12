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
@Table(name = "Card")
/**
 * Card entity class
 * User can have only one card which is connected with only one discount.
 * */
public class CardEntity extends AbstractEntity{
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    @NotNull
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    @NotNull
    private Date endDate;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "discount_id")
    private Long discountId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "discount_id", nullable = false)
//    private DiscountEntity discount;
}
