package com.olawalealex.payment_Service.service;

import com.olawalealex.payment_Service.model.PaymentMode;
import com.olawalealex.payment_Service.model.PaymentRequest;

public interface TransactionsDetailsService {

    long doPayment(PaymentRequest paymentRequest);
}
