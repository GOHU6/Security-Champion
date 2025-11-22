package com.company.expense.secure_expense.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.expense.secure_expense.model.ExpenseEntity;


import com.company.expense.secure_expense.service.ExpenseService;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpenseController {
    
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<ExpenseEntity> list(){
        return expenseService.getAll();
    }

    @PostMapping
    public ExpenseEntity create(ExpenseEntity entity){
        return expenseService.save(entity);
    }
}
