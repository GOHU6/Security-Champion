package com.company.expense.secure_expense.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.company.expense.secure_expense.model.entity.ExpenseEntity;
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

    public ExpenseEntity getById(Long id){
        return expenseRepository.findById(id)
            .orElseThrow(() -> new RuntimeErrorException(null, "not found"));
    }

    public ExpenseEntity save(ExpenseEntity entity){
        return expenseRepository.saveAndFlush(entity);
    }
    
    public ExpenseEntity update(Long id, ExpenseEntity entity){
        ExpenseEntity existing = getById(id);
        existing.setExpenseDate(entity.getExpenseDate());
        existing.setExpenseAmount(entity.getExpenseAmount());
        existing.setExpenseType(entity.getExpenseType());
        return expenseRepository.save(existing);
    }

    public void deleteById(Long id){
        expenseRepository.deleteById(id);
    }

    public void deleteAll(){
        expenseRepository.deleteAll();
    }

}
