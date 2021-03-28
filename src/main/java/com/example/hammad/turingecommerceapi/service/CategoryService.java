package com.example.hammad.turingecommerceapi.service;

import com.example.hammad.turingecommerceapi.dto.CategoryDto;
import com.example.hammad.turingecommerceapi.model.Category;
import com.example.hammad.turingecommerceapi.model.Department;
import com.example.hammad.turingecommerceapi.repository.CategoryRepository;
import com.example.hammad.turingecommerceapi.repository.DepartmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<CategoryDto> getCategories()
    {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        categories.forEach(category -> categoryDtos.add(CategoryDto.convertToDto(category)));
        return categoryDtos;
    }

    public Category addCategory(Category category,Integer deptId)
    {
        Department department = departmentRepository.findById(deptId).get();
        System.out.println(department.getDepartment_id());
        category.setDepartment_id(department);
        return categoryRepository.save(category);
    }

    public CategoryDto getCategoryById(Integer Id)
    {
        Category category = categoryRepository.findById(Id).get();
        CategoryDto categoryDto = CategoryDto.convertToDto(category);
        return categoryDto;
    }

    public List<CategoryDto> getCategoryByProductId(Integer id)
    {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> categories = categoryRepository.getCategoryByProductId(id);
        categories.forEach(category -> categoryDtos.add(CategoryDto.convertToDto(category)));
        return categoryDtos;
    }

    public List<CategoryDto> getCategoryByDepartmentId(Integer id)
    {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> categories = categoryRepository.getCategoriesByDepartment(id);
        categories.forEach(category -> categoryDtos.add(CategoryDto.convertToDto(category)));
        return categoryDtos;
    }

}
