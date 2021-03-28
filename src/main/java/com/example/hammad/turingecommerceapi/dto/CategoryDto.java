package com.example.hammad.turingecommerceapi.dto;

import com.example.hammad.turingecommerceapi.model.Category;
import lombok.Data;

@Data
public class CategoryDto {

    private Integer categoryId;
    private String name;
    private String description;
    private Integer departmentId;

    public static CategoryDto convertToDto(Category category)
    {
        CategoryDto categoryDto = new CategoryDto();
        if (category == null || category.getCategory_id() == null)
        {
            return categoryDto;
        }
        categoryDto.setCategoryId(category.getCategory_id());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setDepartmentId(category.getDepartment_id().getDepartment_id());
        return categoryDto;
    }
}
