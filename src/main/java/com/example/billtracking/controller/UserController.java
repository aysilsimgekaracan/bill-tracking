package com.example.billtracking.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.billtracking.model.User;
import com.example.billtracking.service.UserServiceImpl;

import javax.print.attribute.standard.PresentationDirection;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {
       User loggedIn = userServiceImpl.loginUser(user.getUsername(), user.getPassword());
        if ( loggedIn != null)
            return "welcome";

        return "redirect:/";
    }

    @GetMapping("/adduser")
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/signup")
    public String adduser(@ModelAttribute("user") User user, Model model) {
        userServiceImpl.signup(user);
        return "welcome";
    }





}
