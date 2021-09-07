package com.example.testproject.service;

import com.example.testproject.exception.CategoryNotFoundException;
import com.example.testproject.model.Category;
import com.example.testproject.repository.CategoryRepository;
import com.example.testproject.utils.ObjectCreator;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.example.testproject.utils.ObjectCreator.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;
    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    void getAll() {
        when(categoryRepository.findAll()).thenReturn(categoryList());
        List<Category> categoryList = categoryService.getAll();
        assertFalse(categoryList.isEmpty());
    }

    @Test
    void getByUuid() {
        when(categoryRepository.findById(CATEGORY_UUID)).thenReturn(Optional.of(category()));
        Category category = categoryService.getByUuid(CATEGORY_UUID);
        assertNotNull(category);
    }

    @Test
    void getByUuidThrowEx() {
        when(categoryRepository.findById(CATEGORY_UUID)).thenReturn(Optional.empty());
        assertThrows(CategoryNotFoundException.class, () -> categoryService.getByUuid(CATEGORY_UUID));
    }
}