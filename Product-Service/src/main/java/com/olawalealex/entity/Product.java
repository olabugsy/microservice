package com.olawalealex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data  // Lombok annotation for getters, setters, toString, equals, hashcode
@NoArgsConstructor  // Lombok annotation for no-argument constructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String productName;
    private long price;
    private long quantity;


}
