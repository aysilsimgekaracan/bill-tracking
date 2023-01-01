package com.example.billtracking.service;

import com.example.billtracking.model.User;

import java.util.List;

import com.example.billtracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserServices {

    @Autowired private UserRepository userRepo;

    @Override public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }

    @Override public void signup(User user)
    {
        userRepo.save(user);
    }

    @Override public User getUser(String username)
    {
        User user = userRepo.findByUsername(username);
        if (user == null)
            throw new RuntimeException("User not found for id : " + username);
        return user;
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userRepo.findByUsername(username);

        if (user == null)
            // throw new RuntimeException("User not found for id : " + username);
            return null;

        if (!user.getPassword().equals(password))
            // throw new RuntimeException("Incorrect password for : " + username);
            return null;

        return user;
    }

}
