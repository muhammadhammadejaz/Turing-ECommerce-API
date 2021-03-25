package com.example.hammad.turingecommerceapi.controller;

import com.example.hammad.turingecommerceapi.model.Department;
import com.example.hammad.turingecommerceapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<?> addDepartment(@RequestBody Department department)
    {
        Department dept = departmentService.addDepartment(department);
//        System.out.println(dept.getDepartment_id());
        return new ResponseEntity<Department>(dept, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getDepartments()
    {
        Object[] departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments,HttpStatus.OK);
    }

    @GetMapping("/{department_id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Integer department_id)
    {
        Department department = departmentService.getDepartmentById(department_id);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }
}
