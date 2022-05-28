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
public class Shippers {
    @Id
    @Column(
            name = "shipper_id"
    )
    @SequenceGenerator(
            name = "shipper_id_sequence",
            sequenceName = "shipper_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shipper_id_sequence"
    )
    private int shipperId;

    @Column(
            name = "shipper_name"
    )
    private String shipperName;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "shipperId",
            referencedColumnName = "shipper_id"
    )
    private List<Orders>orders;
}
