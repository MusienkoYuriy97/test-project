package com.example.testproject.service;

import com.example.testproject.exception.CategoryNotFoundException;
import com.example.testproject.model.Category;
import com.example.testproject.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.Optional;

import static com.example.testproject.utils.ObjectCreator.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CategoryServiceTest {
    @InjectMocks
    private CategoryService categoryService;
    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void initMock(){
        MockitoAnnotations.initMocks(this);
    }

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