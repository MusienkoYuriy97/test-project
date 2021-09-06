package com.example.testproject.service;

import com.example.testproject.dto.FormRequest;
import com.example.testproject.mapper.FormMapper;
import com.example.testproject.model.Form;
import com.example.testproject.repository.FormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FormService {
    private final FormRepository formRepository;
    private final CategoryService categoryService;
    private final FormMapper formMapper;

    public Form save(FormRequest formRequest){
        return formRepository.save(fromMapperWithCategory(formRequest));
    }

    public Form update(UUID uuid, FormRequest formRequest) {
        Form form = fromMapperWithCategory(formRequest);
        form.setUuid(uuid);
        return formRepository.save(form);
    }

    private Form fromMapperWithCategory(FormRequest formRequest){
        Form form = formMapper.fromDto(formRequest);
        form.setCategory(categoryService.getByUuid(formRequest.getCategoryUuid()));
        return form;
    }
}
