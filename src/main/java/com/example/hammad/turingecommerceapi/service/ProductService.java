package com.example.hammad.turingecommerceapi.service;

import com.example.hammad.turingecommerceapi.dto.ProductDto;
import com.example.hammad.turingecommerceapi.model.Category;
import com.example.hammad.turingecommerceapi.model.Department;
import com.example.hammad.turingecommerceapi.model.Product;
import com.example.hammad.turingecommerceapi.repository.CategoryRepository;
import com.example.hammad.turingecommerceapi.repository.DepartmentRepository;
import com.example.hammad.turingecommerceapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Product addProduct(Product product,Integer categoryId,Integer departmentId)
    {
        Category category = categoryRepository.findById(categoryId).get();
        Department department = departmentRepository.findById(departmentId).get();
        product.setCategory_id(category);
        product.setDepartment_id(department);
        return productRepository.save(product);
    }

    public List<ProductDto> getProducts(Integer pageNumber,Integer size)
    {
        Pageable pageable = PageRequest.of(pageNumber, size);
        Page<Product> page = productRepository.findAll(pageable);
        List<ProductDto> productDtos = new ArrayList<>();
        List<Product> products = page.toList();
        products.forEach(product -> productDtos.add(ProductDto.convertToDto(product)));
        return productDtos;
    }

    public List<ProductDto> getAllProducts()
    {

        List<Product> productList = productRepository.getAll();
        List<ProductDto> productDtos = ProductDto.convertToDtoList(productList);
        productDtos.stream().count()
        return productDtos;
    }
}
