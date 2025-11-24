package com.company.expense.secure_expense.model.dto;

import java.time.LocalDate;

import com.company.expense.secure_expense.model.enumeration.ExpenseCategory;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseDTO {
    
    private Long id;

    @NotNull(message = "Expense type is required")
    private ExpenseCategory expenseCategory;

    @NotNull(message = "Expense Date is required")
    @PastOrPresent(message = "Expense Date should be in the past or today")
    private LocalDate expenseDate;

    @NotNull(message = "Expense Amount is required")
    @Positive(message = "Expense Amount should be positive")
    private Double expenseAmount;
}
