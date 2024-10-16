package com.olawalealex.orderservice.service;

import com.olawalealex.orderservice.entity.Order;
import com.olawalealex.orderservice.external.client.PaymentRequest;
import com.olawalealex.orderservice.external.client.PaymentService;
import com.olawalealex.orderservice.external.client.ProdServ;
import com.olawalealex.orderservice.model.OrderRequest;
import com.olawalealex.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    ProdServ prodServ;

    @Autowired
    private PaymentService paymentService;


    @Override
    public long createOrder(OrderRequest orderRequest) {
        prodServ.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .quantity(orderRequest.getQuantity())
                .orderDate(Instant.now())
                .build();
        order =orderRepository.save(order);
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .amount(orderRequest.getTotalAmount())
                .orderId(order.getId())
                .paymentMode(orderRequest.getPaymentMode())
                .amount(orderRequest.getTotalAmount())
                .build();

        String  orderStatus=null;
       try {
           paymentService.doPayment(paymentRequest);
           orderStatus = "SUCCESS";
         }catch (Exception e){
           orderStatus="FAILED";
         }

        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
        return order.getId();

    }

}

