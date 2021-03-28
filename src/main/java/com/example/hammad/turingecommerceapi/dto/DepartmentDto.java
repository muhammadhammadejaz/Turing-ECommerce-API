package com.example.hammad.turingecommerceapi.dto;

import com.example.hammad.turingecommerceapi.model.Department;
import lombok.Data;

@Data
public class DepartmentDto {

    private Integer departmentId;
    private String name;
    private String description;

    public static DepartmentDto convertToDto(Department department)
    {
        DepartmentDto departmentDto = new DepartmentDto();
        if (department == null || department.getDepartment_id() == null)
        {
            return departmentDto;
        }
        departmentDto.setDepartmentId(department.getDepartment_id());
        departmentDto.setName(department.getName());
        departmentDto.setDescription(department.getDescription());
        return departmentDto;
    }
}
