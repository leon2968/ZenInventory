package com.zheng.zeninventory.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zheng.zeninventory.model.User;
import com.zheng.zeninventory.repository.UserRepository;
import com.zheng.zeninventory.service.UserServices;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
/*
 * Service implementation for user
 */
public class UserServicesImpl implements UserServices {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServicesImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    /*
     * Method to create a new user
     */
    @Override
    public void saveUser(User user) {
        User _user = new User();
        _user.setName(user.getName());
        _user.setEmail(user.getEmail());
        // encrypt the password using spring security
        _user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(_user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}