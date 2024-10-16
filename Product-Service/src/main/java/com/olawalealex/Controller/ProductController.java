package com.olawalealex.Controller;

import com.olawalealex.entity.Product;
import com.olawalealex.model.ProductRequest;
import com.olawalealex.model.ProductResponse;
import com.olawalealex.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
        try {
            long productId = productService.addProduct(productRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(productId);  // Return 201 Created with the product ID
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();  // Return 400 Bad Request in case of errors
        }


    }

    @GetMapping("/getProduct/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long productId) {
        ProductResponse productResponse = productService.getProduct(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);  // Return 200 OK with the product details

    }

    @PutMapping("/reduceQuantity/{productId}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable long productId, @RequestParam long quantity) {
        productService.reduceQuantity(productId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);  // Return 200 OK if the quantity is reduced successfully
    }


}
