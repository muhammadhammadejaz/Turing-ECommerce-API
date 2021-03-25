package com.example.hammad.turingecommerceapi.service;

import com.example.hammad.turingecommerceapi.model.Category;
import com.example.hammad.turingecommerceapi.model.Department;
import com.example.hammad.turingecommerceapi.repository.CategoryRepository;
import com.example.hammad.turingecommerceapi.repository.DepartmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private DepartmentRepository departmentRepository;

    public Object[] getCategories()
    {
        return categoryRepository.findAll().toArray();
    }

    public Category addCategory(Category category,Integer deptId)
    {
        Department department = departmentRepository.getOne(deptId);
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
        return categoryRepository.getCategoryByProductId(id).toArray();
    }

    public Object[] getCategoryByDepartmentId(Integer id)
    {
        return categoryRepository.getCategoriesByDepartment(id).toArray();
    }

}
