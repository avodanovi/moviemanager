package com.moviemanager.moviemanager.services;

import com.moviemanager.moviemanager.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void addNewCategory(Category category);
    Category findById(Integer category_id);
}
