package com.springjpademo.springdatajpademo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Status {
    @Id
    @Column(
            name = "status_id"
    )
    @SequenceGenerator(
            name = "status_id_sequence",
            sequenceName = "status_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "status_id_sequence"
    )
    private int statusId;

    @Column(
            name = "status_name"
    )
    private String statusName;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "orderStatus",
            referencedColumnName = "status_id"
    )
    private List<Orders> orders;
}
