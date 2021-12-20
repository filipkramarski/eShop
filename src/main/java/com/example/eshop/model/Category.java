package com.example.eshop.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Category {

    private Long id;
    private String name;
    private String description;


    public Category(String name, String description) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
    }
}

