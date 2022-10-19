package com.zheng.zeninventory.service;

import java.util.List;

import com.zheng.zeninventory.model.User;

public interface UserServices {
    void saveUser(User user);

    User findUserByEmail(String email);

    List<User> findAllUsers();
}