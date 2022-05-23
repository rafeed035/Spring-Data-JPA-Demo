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
            name = "quantity_in_stock"
    )
    private int quantityInStock;

    @Column(
            name = "unit_price"
    )
    private float unitPrice;
}
