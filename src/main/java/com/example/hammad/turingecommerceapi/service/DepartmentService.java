package com.example.hammad.turingecommerceapi.service;

import com.example.hammad.turingecommerceapi.dto.DepartmentDto;
import com.example.hammad.turingecommerceapi.model.Department;
import com.example.hammad.turingecommerceapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department)
    {
        return departmentRepository.save(department);
    }

    public List<DepartmentDto> getAllDepartments()
    {
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> departmentDtoList.add(DepartmentDto.convertToDto(department)));
        return departmentDtoList;
    }

    public DepartmentDto getDepartmentById(Integer Id)
    {
        Department department = departmentRepository.findById(Id).get();
        DepartmentDto departmentDto = DepartmentDto.convertToDto(department);
        return departmentDto;
    }
}
