package com.example.hammad.turingecommerceapi.service;

import com.example.hammad.turingecommerceapi.model.Category;
import com.example.hammad.turingecommerceapi.model.Department;
import com.example.hammad.turingecommerceapi.model.Product;
import com.example.hammad.turingecommerceapi.repository.CategoryRepository;
import com.example.hammad.turingecommerceapi.repository.DepartmentRepository;
import com.example.hammad.turingecommerceapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public Product addProduct(Product product,Integer categoryId,Integer departmentId)
    {
        Category category = categoryRepository.findById(categoryId).get();
        Department department = departmentRepository.findById(departmentId).get();
        product.setCategory_id(category);
        product.setDepartment_id(department);
        return productRepository.save(product);
    }
}
