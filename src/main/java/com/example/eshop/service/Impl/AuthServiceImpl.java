package com.example.eshop.service.Impl;


import com.example.eshop.model.User;
import com.example.eshop.model.exceptions.InvalidArgumentsException;
import com.example.eshop.model.exceptions.InvalidUserCredentialsException;
import com.example.eshop.model.exceptions.PasswordsDoNotMatchException;
import com.example.eshop.model.exceptions.UsernameAlreadyExistsException;
import com.example.eshop.repository.impl.InMemoryUserRepository;
import com.example.eshop.repository.jpa.UserRepository;
import com.example.eshop.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }
}

