package com.example.testproject.mapper;

import com.example.testproject.dto.FormRequest;
import com.example.testproject.model.Form;

public interface FormMapper {
    Form fromDto(FormRequest formRequest);
}
