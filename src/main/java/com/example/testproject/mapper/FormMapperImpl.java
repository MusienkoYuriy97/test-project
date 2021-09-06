package com.example.testproject.mapper;

import com.example.testproject.dto.FormRequest;
import com.example.testproject.model.Form;
import org.springframework.stereotype.Component;

@Component
public class FormMapperImpl implements FormMapper{
    @Override
    public Form fromDto(FormRequest formRequest) {
        Form form = new Form();
        form.setUserName(formRequest.getUserName());
        form.setAgreeToTerms(formRequest.isAgreeToTerms());
        return form;
    }
}
