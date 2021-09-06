package com.example.testproject.repository;

import com.example.testproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    @Override
    @Query("SELECT c FROM Category c WHERE c.parentCategory = null")
    List<Category> findAll();
}
