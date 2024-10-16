package com.olawalealex.payment_Service.controller;

import com.olawalealex.payment_Service.model.PaymentRequest;
import com.olawalealex.payment_Service.service.TransactionsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class TransactionDetailsController {

    @Autowired
    private TransactionsDetailsService transactionsDetailsService;

    @PostMapping("/doPayment")
    public ResponseEntity<Long> doPayment(PaymentRequest paymentRequest) {
        transactionsDetailsService.doPayment(paymentRequest);
        return new ResponseEntity<>(HttpStatus.OK);


    }

}
