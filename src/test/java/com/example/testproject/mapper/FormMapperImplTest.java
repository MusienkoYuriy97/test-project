package com.example.testproject.mapper;

import com.example.testproject.dto.FormRequest;
import com.example.testproject.model.Form;
import com.example.testproject.utils.ObjectCreator;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FormMapperImplTest {
    private final FormMapper formMapper = new FormMapperImpl();

    @Test
    void fromDto() {
        FormRequest formRequest = ObjectCreator.formRequest();
        Form form = formMapper.fromDto(formRequest);
        assertEquals(formRequest.getUserName(), form.getUserName());
        assertEquals(formRequest.isAgreeToTerms(), form.getAgreeToTerms());
    }
}