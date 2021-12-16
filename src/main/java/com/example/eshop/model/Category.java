package com.example.eshop.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Category {

    private String name;
    private String description;


    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

