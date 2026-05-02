package com.joao.spring.security.jwt.service;

import com.joao.spring.security.jwt.model.User;
import com.joao.spring.security.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void createUser(User user) {
        String pass = user.getPassword();
        user.setPassword(encoder().encode(pass));
        repository.save(user);
    }

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
