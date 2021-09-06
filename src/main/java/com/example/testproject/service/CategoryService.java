package com.example.testproject.service;

import com.example.testproject.exception.CategoryNotFoundException;
import com.example.testproject.model.Category;
import com.example.testproject.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category getByUuid(UUID uuid){
        return categoryRepository.findById(uuid)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));
    }
}
