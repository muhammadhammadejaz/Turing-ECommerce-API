package com.example.hammad.turingecommerceapi.service;

import com.example.hammad.turingecommerceapi.model.Product;
import com.example.hammad.turingecommerceapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public Product addProduct(Product product)
    {
       return productRepository.save(product);
    }
}
