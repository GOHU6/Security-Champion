package com.company.expense.secure_expense.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.company.expense.secure_expense.model.dto.ExpenseDTO;
import com.company.expense.secure_expense.model.entity.ExpenseEntity;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {
    ExpenseDTO expenseToDTO(ExpenseEntity entity);
    ExpenseEntity expenseToEntity(ExpenseDTO dto);

    @Mapping(target = "id", ignore = true)
    void updateExpenseFromDto(ExpenseDTO dto, @MappingTarget ExpenseEntity entity);
}
