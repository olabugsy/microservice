package com.olawalealex.orderservice.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT-SERVICE/product")
public interface ProdServ {

    @PutMapping("/reduceQuantity/{productId}")
    void reduceQuantity(@PathVariable long productId, @RequestParam long quantity);


}
