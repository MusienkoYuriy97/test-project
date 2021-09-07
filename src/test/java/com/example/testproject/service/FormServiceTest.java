package com.example.testproject.service;

import com.example.testproject.mapper.FormMapper;
import com.example.testproject.mapper.FormMapperImpl;
import com.example.testproject.model.Form;
import com.example.testproject.repository.FormRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.example.testproject.utils.ObjectCreator.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class FormServiceTest {
    @InjectMocks
    private FormService formService;
    @Mock
    private FormRepository formRepository;
    @Mock
    private CategoryService categoryService;
    private FormMapper formMapper = new FormMapperImpl();

    @BeforeEach
    public void initMock(){
        formService = new FormService(formRepository,categoryService,formMapper);
    }

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