package com.olawalealex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequest {


    private String productName;
    private long price;
    private long quantity;
}
