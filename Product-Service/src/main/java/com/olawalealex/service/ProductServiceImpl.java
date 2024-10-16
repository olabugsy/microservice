package com.olawalealex.service;

import com.olawalealex.entity.Product;
import com.olawalealex.model.ProductRequest;
import com.olawalealex.model.ProductResponse;
import com.olawalealex.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
         productRepository.save(product);
            return product.getProductId();
    }



    @Override
    public ProductResponse getProduct(long productId) {

        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;


    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new RuntimeException("Product not found"));
        if(product.getQuantity() < quantity) {
            throw new RuntimeException("Insufficient quantity");
        }
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }


}
