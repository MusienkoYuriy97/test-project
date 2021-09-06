package com.example.testproject.config;

import com.example.testproject.mapper.FormMapper;
import com.example.testproject.mapper.FormMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public FormMapper formMapper(){
        return new FormMapperImpl();
    }
}
