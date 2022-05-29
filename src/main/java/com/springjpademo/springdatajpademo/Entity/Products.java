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
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "name_unique",
                columnNames = "product_name"
        )
)
public class Products {
    @Id
    @Column(
            name = "product_id"
    )
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private int productId;

    @Column(
            name = "product_name"
    )
    private String productName;

    @Column(
            name = "unit_price"
    )
    private float unitPrice;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = true
    )
    private Customer customer;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<Orders> orders;

}
