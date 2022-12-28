package com.example.billtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.billtracking.model.Expense;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
}
