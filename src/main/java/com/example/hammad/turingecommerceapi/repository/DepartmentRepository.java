package com.example.hammad.turingecommerceapi.repository;

import com.example.hammad.turingecommerceapi.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
