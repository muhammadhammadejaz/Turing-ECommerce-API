package com.example.hammad.turingecommerceapi.repository;

import com.example.hammad.turingecommerceapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query(value = "select category_id,name,department_id,description" +
            "from" +
            "Category" +
            "where department_id = :department_id",nativeQuery = true)
    public List<Category> getCategoriesByDepartment(@Param("department_id") Integer department_id);

    @Query(value = "select c.category_id,c.name,c.department_id " +
            "from Category c" +
            "inner join " +
            "Product p on c.category_id = p.category_id" +
            "where p.product_id = :productId",nativeQuery = true)
    public List<Category> getCategoryByProductId(@Param("productId") Integer productId);
}
