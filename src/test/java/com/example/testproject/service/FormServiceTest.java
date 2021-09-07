package com.example.testproject.service;

import com.example.testproject.model.Form;
import com.example.testproject.repository.FormRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.example.testproject.utils.ObjectCreator.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class FormServiceTest {
    @Autowired
    private FormService formService;
    @MockBean
    private FormRepository formRepository;
    @MockBean
    private CategoryService categoryService;

    @Test
    void save() {
        when(formRepository.save(any(Form.class))).thenReturn(formAfterSaving());
        when(categoryService.getByUuid(CATEGORY_UUID)).thenReturn(category());
        Form form = formService.save(formRequest());
        assertNotNull(form);
    }

    @Test
    void update() {
        when(formRepository.save(any(Form.class))).thenReturn(formAfterSaving());
        when(categoryService.getByUuid(CATEGORY_UUID)).thenReturn(category());
        Form form = formService.update(FORM_UUID, formRequest());
        assertNotNull(form);
    }
}