package com.example.billtracking.service;

import com.example.billtracking.model.User;
import com.example.billtracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.billtracking.model.Expense;
import com.example.billtracking.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseServices {

    @Autowired private ExpenseRepository expenseRepo;

    @Override public void addExpense(Expense expense) {
        expenseRepo.save(expense);
    }

    @Override
    public void deleteExpense(Expense expense) {
        expenseRepo.delete(expense);
    }

}
