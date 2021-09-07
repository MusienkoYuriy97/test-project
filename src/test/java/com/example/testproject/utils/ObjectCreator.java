package com.example.testproject.utils;

import com.example.testproject.dto.FormRequest;
import com.example.testproject.model.Category;
import com.example.testproject.model.Form;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ObjectCreator {
    public static final UUID CATEGORY_UUID = UUID.fromString("8470f72a-4b8e-4955-90e1-1fcc1c60a56f");
    public static final UUID FORM_UUID = UUID.fromString("2470f72a-4b8e-4955-90e1-1fcc1c60a56f");

    public static FormRequest formRequest(){
        FormRequest formRequest = new FormRequest();
        formRequest.setUserName("Yury");
        formRequest.setCategoryUuid(CATEGORY_UUID);
        formRequest.setAgreeToTerms(true);
        return formRequest;
    }

    public static Form form(){
        Form form = new Form();
        form.setUserName("Yury");
        form.setCategory(category());
        form.setAgreeToTerms(true);
        return form;
    }
    public static Form formAfterSaving(){
        Form form = form();
        form.setUuid(FORM_UUID);
        return form;
    }

    public static List<Category> categoryList(){
        Category category = new Category("Test", null);
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        return categoryList;
    }

    public static Category category(){
        Category category = new Category("Test", null);
        category.setUuid(CATEGORY_UUID);
        return category;
    }
}
