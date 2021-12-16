package com.example.eshop.service;


import com.example.eshop.model.User;

public interface AuthService {

    User login(String username, String password);
    User register(String username, String password, String repeatPassword, String name, String surname);

}

