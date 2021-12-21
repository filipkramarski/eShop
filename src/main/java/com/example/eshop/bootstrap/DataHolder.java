package com.example.eshop.bootstrap;

import com.example.eshop.model.Category;
import com.example.eshop.model.Manufacturer;
import com.example.eshop.model.Product;
import com.example.eshop.model.User;
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

    @PostConstruct
            public void init() {
            categories.add(new Category("Movies", "Movies category"));
            categories.add(new Category("Books", "Books category"));
            categories.add(new Category("Software", "Software category"));

            users.add(new User("kostadin.mishev", "km", "Kostadin", "Mishev"));
            users.add(new User("riste.stojanov", "rs", "Riste", "Stojanov"));

            Manufacturer manufacturer = new Manufacturer("NIKE", "NY NY");
            manufacturers.add(manufacturer);
            manufacturers.add(new Manufacturer("Apple", "LA LA"));

            Category category = new Category("Sport", "Sport category");
            categories.add(category);
            products.add(new Product("Ball 1", 235.8, 7, category, manufacturer));
            products.add(new Product("Ball 2", 235.8, 7, category, manufacturer));
            products.add(new Product("Ball 3", 235.8, 7, category, manufacturer));
    }
}

