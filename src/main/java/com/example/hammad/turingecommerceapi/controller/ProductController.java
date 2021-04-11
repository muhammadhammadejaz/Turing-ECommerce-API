package com.example.hammad.turingecommerceapi.controller;

import com.example.hammad.turingecommerceapi.model.Product;
import com.example.hammad.turingecommerceapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/category/{catId}/department/{deptId}")
    public ResponseEntity<?> addController(@RequestBody Product product, @PathVariable Integer catId, @PathVariable Integer deptId)
    {
        Product prod = productService.addProduct(product,catId,deptId);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }

    public ResponseEntity<?> getProducts(@PathVariable Integer page,@PathVariable Integer size)
    {

    }
}
