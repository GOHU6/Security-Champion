package com.company.expense.secure_expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.expense.secure_expense.model.ExpenseEntity;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long>{
    
}
