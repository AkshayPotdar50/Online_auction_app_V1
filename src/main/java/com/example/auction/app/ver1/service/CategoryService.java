package com.example.auction.app.ver1.service;

import com.example.auction.app.ver1.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
    Optional<Category> getCategoryById(Long id);
    List<Category> getAllCategories();
}
