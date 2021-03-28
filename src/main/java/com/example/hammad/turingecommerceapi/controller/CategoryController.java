package com.example.hammad.turingecommerceapi.controller;

import com.example.hammad.turingecommerceapi.dto.CategoryDto;
import com.example.hammad.turingecommerceapi.model.Category;
import com.example.hammad.turingecommerceapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/department/{deptId}/add")
    public ResponseEntity<?> addCategory(@RequestBody Category category,@PathVariable Integer deptId)
    {
        Category cat = categoryService.addCategory(category,deptId);
        return new ResponseEntity<Category>(cat, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getCategories()
    {
        List<CategoryDto> categories = categoryService.getCategories();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer Id)
    {
        CategoryDto category = categoryService.getCategoryById(Id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @GetMapping("/inProduct/{product_id}")
    public ResponseEntity<?> getCategoryByProductId(@PathVariable Integer product_id)
    {
        List<CategoryDto> cat_prod = categoryService.getCategoryByProductId(product_id);
        return new ResponseEntity<>(cat_prod,HttpStatus.OK);
    }

    @GetMapping("/inDepartment/{department_id}")
    public ResponseEntity<?> getCategoryByDepartmentId(@PathVariable Integer department_id)
    {
        List<CategoryDto> cat_dept = categoryService.getCategoryByDepartmentId(department_id);
        return new ResponseEntity<>(cat_dept,HttpStatus.OK);
    }
}
