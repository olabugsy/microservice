package com.olawalealex.orderservice.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "PAYMENT-SERVICE/payment")
public interface PaymentService {

    @PostMapping("/doPayment")
    public ResponseEntity<Long> doPayment(PaymentRequest paymentRequest);
}
