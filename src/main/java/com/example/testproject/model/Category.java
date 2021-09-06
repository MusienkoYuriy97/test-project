package com.example.testproject.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "category")
@Getter
@Setter
@JsonIgnoreProperties({"parentCategory"})
public class Category {
    @Id
    @Column(name = "uuid", nullable = false)
    @GeneratedValue
    private UUID uuid;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_uuid", referencedColumnName = "uuid")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.EAGER)
    private List<Category> childCategories = new ArrayList<>();

    protected Category() {}

    public Category(String name, Category parentCategory) {
        this.name = name;
        this.parentCategory = parentCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                '}';
    }
}
