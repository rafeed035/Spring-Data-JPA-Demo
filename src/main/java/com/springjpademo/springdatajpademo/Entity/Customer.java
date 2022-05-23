package com.springjpademo.springdatajpademo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "phone_unique",
                columnNames = "phone"
        )
)
public class Customer {
    @Id
    @Column(name = "customer_id")
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private int customerId;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    @Column(name = "birth_date")
    private String birthDate;

    private String phone;
    private String address;
    private String city;
    private String state;
    private int points;
}

