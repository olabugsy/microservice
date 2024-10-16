package com.olawalealex.orderservice.service;

import com.olawalealex.orderservice.model.OrderRequest;

public interface OrderService {

    public long createOrder(OrderRequest orderRequest);

}
