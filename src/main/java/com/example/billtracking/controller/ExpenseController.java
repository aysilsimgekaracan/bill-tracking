package com.example.billtracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.billtracking.model.User;
import com.example.billtracking.service.UserServiceImpl;
import com.example.billtracking.model.Expense;
import com.example.billtracking.repository.UserRepository;
import com.example.billtracking.repository.ExpenseRepository;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Controller
public class ExpenseController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired private UserRepository userRepo;
    @Autowired private ExpenseRepository expenseRepo;

    @GetMapping("/expenses")
    public String expense(Model model) {
        List<User> usersList = userRepo.findAll();
        model.addAttribute("usersList", usersList);

        model.addAttribute("selectedUser", null);
        model.addAttribute("expenses", null);

        return "expenses";
    }

    @PostMapping("/expenses")
    public String selectUser(@RequestParam("user") String username, Model model) {
        if (username == null || username.isEmpty()) {
            model.addAttribute("errorMessage", "Please select a user.");
            return "expenses";
        }

        User selectedUser = userRepo.findByUsername(username);
        model.addAttribute("selectedUser", selectedUser);

        List<Expense> expenses = expenseRepo.findByUserUsername(username);
        model.addAttribute("expenses", expenses);

        model.addAttribute("usersList", userRepo.findAll());

        return "expenses";
    }

    @GetMapping("/addexpensepage")
    public String addExpensePage(@RequestParam String selectedUser, Model model) {
        User user = userRepo.findByUsername(selectedUser);
        Expense expense = new Expense();

        model.addAttribute("user", user);

        expense.setUser(user);
        model.addAttribute("expense", expense);
        return "addexpense";
    }

    @PostMapping("/addexpense")
    public String addExpense(@ModelAttribute Expense expense, Model model) {
        // Save the new expense to the database
        expenseRepo.save(expense);

        // Redirect to the expenses page
        return "redirect:/expenses";
    }
}
