package com.example.eshop.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Manufacturer manufacturer;

    public Product () {
    }

    public Product (String name, Double price, Integer quantity, Category category, Manufacturer manufacturer) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.manufacturer = manufacturer;
    }
}
