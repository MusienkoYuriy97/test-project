package com.example.testproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "form")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Form {
    @Id
    @Column(name = "uuid", nullable = false)
    @GeneratedValue
    private UUID uuid;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @OneToOne
    private Category category;

    @Column(name = "agree_to_terms")
    private Boolean agreeToTerms;
}
