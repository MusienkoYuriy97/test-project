package com.example.testproject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class FormRequest {
    @NotNull
    @NotBlank
    private String userName;

    @NotNull
    private UUID categoryUuid;

    private boolean agreeToTerms;
}
