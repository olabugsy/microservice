package com.olawalealex.orderservice.controller;

import com.olawalealex.orderservice.model.OrderRequest;
import com.olawalealex.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Long> createOrder(@RequestBody OrderRequest orderRequest) {
        // Call the service to create the order
        long orderId = orderService.createOrder(orderRequest);

        // Return the ID of the newly created order and HTTP 201 status
        return ResponseEntity.status(201).body(orderId);
    }

}
