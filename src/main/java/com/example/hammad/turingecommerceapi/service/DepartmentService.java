package com.example.hammad.turingecommerceapi.service;

import com.example.hammad.turingecommerceapi.model.Department;
import com.example.hammad.turingecommerceapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department)
    {
        return departmentRepository.save(department);
    }

    public Object[] getAllDepartments()
    {
        return departmentRepository.findAll().toArray();
    }

    public Department getDepartmentById(Integer Id)
    {
        return departmentRepository.findById(Id).get();
    }
}
