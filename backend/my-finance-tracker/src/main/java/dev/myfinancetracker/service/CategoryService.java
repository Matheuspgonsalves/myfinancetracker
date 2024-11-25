package dev.myfinancetracker.service;

import dev.myfinancetracker.model.CategoryModel;
import dev.myfinancetracker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public CategoryModel createCategory(CategoryModel category){
        return categoryRepository.save(category);
    }

    public List<CategoryModel> getAllCategories(){
        return categoryRepository.findAll();
    }

    public CategoryModel updateCategory(int id, CategoryModel categoryDetails){
        CategoryModel category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(categoryDetails.getName());

        return categoryRepository.save(category);
    }

    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }
}
