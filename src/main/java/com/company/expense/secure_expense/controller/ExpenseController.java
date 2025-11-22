package com.company.expense.secure_expense.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.expense.secure_expense.model.entity.ExpenseEntity;
import com.company.expense.secure_expense.service.ExpenseService;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpenseController {
    
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<ExpenseEntity> getAll(){
        return expenseService.getAll();
    }

    @GetMapping("/{id}")
    public ExpenseEntity getById(@PathVariable Long id){
        return expenseService.getById(id);
    }

    @PostMapping
    public ExpenseEntity create(@RequestBody ExpenseEntity entity){
        return expenseService.save(entity);
    }
    
    @PutMapping("/{id}")
    public ExpenseEntity update(@PathVariable Long id, @RequestBody ExpenseEntity entity){
        return expenseService.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        expenseService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll(){
        expenseService.deleteAll();
    }
}
