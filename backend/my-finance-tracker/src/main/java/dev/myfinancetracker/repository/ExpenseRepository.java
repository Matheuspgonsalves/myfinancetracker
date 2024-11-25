package dev.myfinancetracker.repository;

import dev.myfinancetracker.model.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseModel, Integer> {
}
