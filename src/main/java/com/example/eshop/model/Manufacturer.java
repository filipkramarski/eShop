package com.example.eshop.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Getter
@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "manufacturers_address")
    private String address;

    public Manufacturer () {
    }
    public Manufacturer (String name, String address) {
        this.name = name;
        this.address = address;
    }
}
