package com.example.testproject.controller;

import com.example.testproject.dto.FormRequest;
import com.example.testproject.model.Form;
import com.example.testproject.service.CategoryService;
import com.example.testproject.service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormController {
    private final FormService formService;
    private final CategoryService categoryService;

    @GetMapping
    public String getForm(Model model){
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("formRequest",new FormRequest());
        return "form";
    }

    @PostMapping
    public String saveForm(@Valid @ModelAttribute("formRequest") FormRequest formRequest,
                           BindingResult bindingResult,
                           HttpSession httpSession,
                           Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAll());
            return "form";
        }

        Object sessionForm = httpSession.getAttribute("form");
        if (sessionForm == null){
            Form form = formService.save(formRequest);
            httpSession.setAttribute("form", form);
        }else {
            UUID uuid = ((Form) sessionForm).getUuid();
            formService.update(uuid, formRequest);
        }
        model.addAttribute("categories", categoryService.getAll());
        return "form";
    }
}