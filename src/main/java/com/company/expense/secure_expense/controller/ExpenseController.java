package com.company.expense.secure_expense.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.expense.secure_expense.model.dto.ExpenseDTO;
import com.company.expense.secure_expense.service.ExpenseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/expenses")
@Validated
public class ExpenseController {
    
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<ExpenseDTO> getAll(){
        return expenseService.getAll();
    }

    @GetMapping("/{id}")
    public ExpenseDTO getById(@PathVariable Long id){
        return expenseService.getById(id);
    }

    @PostMapping
    public ResponseEntity<ExpenseDTO> create(@Valid @RequestBody ExpenseDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.save(dto));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDTO> update(@PathVariable Long id, @Valid @RequestBody ExpenseDTO dto){
       return ResponseEntity.ok(expenseService.update(id, dto));
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
