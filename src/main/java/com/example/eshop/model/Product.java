package com.example.eshop.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Getter
@Entity
public class Product {

    @Id
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Manufacturer manufacturer;

    public Product (String name, Double price, Integer quantity, Category category, Manufacturer manufacturer) {
        this.id = (long) (Math.random()*1000);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.manufacturer = manufacturer;
    }
}
