package com.company.expense.secure_expense.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.expense.secure_expense.model.ExpenseEntity;
import com.company.expense.secure_expense.repository.ExpenseRepository;

@Service
public class ExpenseService {
    
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public List<ExpenseEntity> getAll(){
        return expenseRepository.findAll();
    }

    public ExpenseEntity save(ExpenseEntity entity){
        return expenseRepository.saveAndFlush(entity);
    }
}
