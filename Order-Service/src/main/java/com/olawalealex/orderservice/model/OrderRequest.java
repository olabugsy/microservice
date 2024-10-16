package com.olawalealex.orderservice.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderRequest {

    private long productId;
    private long totalAmount;
    private long quantity;
    private PaymentMode paymentMode;

}
