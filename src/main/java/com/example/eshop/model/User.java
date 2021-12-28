package com.example.eshop.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Entity
@Table(name = "shop_users")
public class User {

    @Id
    private String username;

    private String password;

    private String name;

    private String surname;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<ShoppingCart> carts;

    public User () {
    }

    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}

