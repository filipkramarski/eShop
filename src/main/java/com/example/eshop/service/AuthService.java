package com.example.eshop.service;


import com.example.eshop.model.User;

public interface AuthService {

    User login(String username, String password);


}

