package dev.myfinancetracker.repository;

import dev.myfinancetracker.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {
}
