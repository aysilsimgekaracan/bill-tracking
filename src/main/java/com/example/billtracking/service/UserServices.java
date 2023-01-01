package com.example.billtracking.service;

import java.util.List;

import com.example.billtracking.model.User;

public interface UserServices {
    List<User> getAllUsers();
    void signup(User user);
    User getUser(String username);

    User loginUser(String username, String password);
}