package com.example.hammad.turingecommerceapi.service;

import com.example.hammad.turingecommerceapi.model.Category;
import com.example.hammad.turingecommerceapi.model.Department;
import com.example.hammad.turingecommerceapi.repository.CategoryRepository;
import com.example.hammad.turingecommerceapi.repository.DepartmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public Object[] getCategories()
    {
        return categoryRepository.findAll().toArray();
    }

    public Category addCategory(Category category,Integer deptId)
    {
        Department department = departmentRepository.findById(deptId).get();
        System.out.println(department.getDepartment_id());
        category.setDepartment_id(department);
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Integer Id)
    {
        Category category = categoryRepository.findById(Id).get();
        return category;
    }

    public Object[] getCategoryByProductId(Integer id)
    {
        Object[] arr = categoryRepository.getCategoryByProductId(id).toArray();

        return arr;
    }

    public Object[] getCategoryByDepartmentId(Integer id)
    {
        return categoryRepository.getCategoriesByDepartment(id).toArray();
    }

}
