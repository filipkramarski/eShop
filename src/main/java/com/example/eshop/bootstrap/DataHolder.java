package com.example.eshop.bootstrap;

import com.example.eshop.model.*;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Getter
@Component
public class DataHolder {

    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<ShoppingCart> shoppingCarts = new ArrayList<>();

    @PostConstruct
            public void init() {
            categories.add(new Category("Movies", "Movies category"));
            categories.add(new Category("Books", "Books category"));
            categories.add(new Category("Software", "Software category"));

            users.add(new User("filipkramarski", "fk", "Filip", "Kramarski"));
            users.add(new User("sandrakramarska", "sk", "Sandra", "Kramarska"));

            Manufacturer manufacturer = new Manufacturer("NIKE", "NY NY");
            manufacturers.add(manufacturer);
            manufacturers.add(new Manufacturer("Apple", "LA LA"));

            Category category = new Category("Sport", "Sport category");
            categories.add(category);
            products.add(new Product("Ball 1", 235.8, 7, category, manufacturer));
            products.add(new Product("Harry Potter", 235.8, 7, category, manufacturer));
            products.add(new Product("Android", 235.8, 7, category, manufacturer));

    }
}

