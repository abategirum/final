package org.example.finalexam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private BigDecimal price;

//    @ManyToOne
//    @JoinColumn(name = "orderId", nullable = false)
//    private Order order;


    public Product(String productName, BigDecimal price) {

        this.productName = productName;
        this.price = price;
//        this.order = order;
    }
}
