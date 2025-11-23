package com.company.expense.secure_expense.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.company.expense.secure_expense.mapper.ExpenseMapper;
import com.company.expense.secure_expense.model.dto.ExpenseDTO;
import com.company.expense.secure_expense.model.entity.ExpenseEntity;
import com.company.expense.secure_expense.repository.ExpenseRepository;

@Service
public class ExpenseService {
    
    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    public ExpenseService(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper){
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
    }

    public List<ExpenseDTO> getAll(){
        return expenseRepository.findAll()
            .stream()
            .map(expenseMapper::expenseToDTO)
            .toList();
    }

    public ExpenseDTO getById(Long id){
        ExpenseEntity entity = expenseRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found - getById function"));
        return expenseMapper.expenseToDTO(entity);
    }

    public ExpenseDTO save(ExpenseDTO dto){
        ExpenseEntity expenseEntity = expenseMapper.expenseToEntity(dto);
        ExpenseEntity saveEntity = expenseRepository.saveAndFlush(expenseEntity);
        return expenseMapper.expenseToDTO(saveEntity);
    }
    
    public ExpenseDTO update(Long id, ExpenseDTO dto){
        ExpenseEntity entity = expenseRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found - update function"));
        
        expenseMapper.updateExpenseFromDto(dto, entity);
        ExpenseEntity updated = expenseRepository.saveAndFlush(entity);
        return expenseMapper.expenseToDTO(updated);
    }

    public void deleteById(Long id){
        if (!expenseRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found - deleteById function");
        }
        expenseRepository.deleteById(id);
    }

    public void deleteAll(){
        expenseRepository.deleteAll();
    }

}
