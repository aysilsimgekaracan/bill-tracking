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
import com.example.billtracking.model.Expense;
import com.example.billtracking.repository.UserRepository;
import com.example.billtracking.repository.ExpenseRepository;
import java.util.Calendar;
import java.util.Date;


@Controller
public class ExpenseController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired private UserRepository userRepo;
    @Autowired private ExpenseRepository expenseRepo;

    @GetMapping("/expenses")
    public String expense(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "expenses";
    }

    @GetMapping("/addexpensepage")
    public String addExpensePage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addexpensepage";
    }

    @GetMapping("/addexpense")
    public String addExpense(Model model) {
        return "newaddexpense";
    }

    @PostMapping("/newaddexpense")
    public String postAddExpense(Model model) {

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        User user = new User();
        user.setId(123);
        user.setEmail("abc@abc.com");
        user.setUsername("abc");
        user.setName("abc");
        user.setPassword("abc");

        userRepo.save(user);

        Expense expense = new Expense();
        expense.setAmount(1);
        expense.setDate(date);
        expense.setDescription("This is my first expenseee");
        expense.setUser(user);

        expenseRepo.save(expense);

        return "welcome";
    }
}
