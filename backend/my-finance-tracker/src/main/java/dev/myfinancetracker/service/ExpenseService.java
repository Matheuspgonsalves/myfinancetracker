package dev.myfinancetracker.service;

import dev.myfinancetracker.model.ExpenseModel;
import dev.myfinancetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseModel createExpense(ExpenseModel expense) {
        return expenseRepository.save(expense);
    }

    public List<ExpenseModel> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public ExpenseModel updateExpense(int id, ExpenseModel expenseDetails) {
        ExpenseModel expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        expense.setName(expenseDetails.getName());
        expense.setCategory(expenseDetails.getCategory());
        expense.setDescription(expenseDetails.getDescription());
        expense.setAmount(expenseDetails.getAmount());

        return expenseRepository.save(expense);
    }

    public void deleteExpense(int id) {
        expenseRepository.deleteById(id);
    }
}
