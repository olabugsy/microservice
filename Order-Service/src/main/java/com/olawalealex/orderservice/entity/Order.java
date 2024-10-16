package com.olawalealex.orderservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "orders",schema = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")  // Maps to the 'id' column in the orders table
    private long id;

    @Column(name = "product_id", nullable = false)  // Maps to 'product_id', cannot be null
    private long productId;

    @Column(name = "quantity", nullable = false)  // Maps to 'quantity', cannot be null
    private long quantity;

    @Column(name = "order_date", nullable = false)  // Maps to 'order_date', cannot be null
    private Instant orderDate;

    @Column(name = "order_status", length = 255, nullable = false)  // Maps to 'order_status', string length 255, cannot be null
    private String orderStatus;

    @Column(name = "amount", nullable = false)  // Maps to 'amount', cannot be null
    private long amount;
}
