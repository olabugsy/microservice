package com.olawalealex.payment_Service.service;

import com.olawalealex.payment_Service.entity.TransactionDetails;
import com.olawalealex.payment_Service.model.PaymentRequest;
import com.olawalealex.payment_Service.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TransactionsDetailsServiceImpl implements TransactionsDetailsService {

    @Autowired
    private PaymentDetailsRepository paymentDetailsRepository;


    @Override
    public long doPayment(PaymentRequest paymentRequest) {

        TransactionDetails transactionDetails = TransactionDetails.builder()
                .orderid(paymentRequest.getOrderId())
                .paymentMode(paymentRequest.getPaymentMode())
                .amount(paymentRequest.getAmount())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .paymentDate(Instant.now())
                .PaymentStatus("SUCCESS")
                .build();
        paymentDetailsRepository.save(transactionDetails);

        return transactionDetails.getId();

    }

}
