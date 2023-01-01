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
import java.util.Optional;


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
            model.addAttribute("usersList", userRepo.findAll());
            return "expenses";
        }

        User selectedUser = userRepo.findByUsername(username);
        model.addAttribute("selectedUser", selectedUser);

        List<Expense> expenses = expenseRepo.findByUserUsername(username);
        model.addAttribute("expenses", expenses);

        model.addAttribute("usersList", userRepo.findAll());

        return "expenses";
    }

    @GetMapping("/expenses/{id}/delete")
    public String deleteExpense(@PathVariable Integer id, Model model) {
        Expense expense = expenseRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid expense id"));

        model.addAttribute("usersList", userRepo.findAll());
        model.addAttribute("selectedUser", expense.getUser());

        expenseRepo.delete(expense);

        model.addAttribute("expenses", expenseRepo.findByUserUsername(expense.getUser().getUsername()));

        return "expenses";
    }

    @GetMapping("/addexpense")
    public String addExpensePage(Model model) {

        List<User> usersList = userRepo.findAll();
        model.addAttribute("usersList", usersList);
        model.addAttribute("selectedUser", null);
        model.addAttribute("expense", new Expense());

        return "addexpense";
    }

    @PostMapping("/addexpense")
    public String addExpense(@ModelAttribute Expense expense, @RequestParam("user") String username, Model model) {
        // Save the new expense to the database

        if (username == null || username.isEmpty()) {
            model.addAttribute("errorMessage", "Please select a user.");
            model.addAttribute("usersList", userRepo.findAll());
            return "addexpense";
        }

        User selectedUser = userRepo.findByUsername(username);
        model.addAttribute("selectedUser", selectedUser);
        expense.setUser(selectedUser);

        expenseRepo.save(expense);

        // Redirect to the expenses page
        return "redirect:/expenses";
    }
}
