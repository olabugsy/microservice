package com.olawalealex.service;


import com.olawalealex.entity.Product;
import com.olawalealex.model.ProductRequest;
import com.olawalealex.model.ProductResponse;

public interface ProductService {

    public long addProduct(ProductRequest productRequest);


    ProductResponse getProduct(long productId);

    void reduceQuantity(long productId, long quantity);


}