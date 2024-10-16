package com.olawalealex.orderservice.external.client;

import com.olawalealex.orderservice.model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {

    private long orderId;
    private PaymentMode paymentMode;
    private long amount;
    private String referenceNumber;

}
