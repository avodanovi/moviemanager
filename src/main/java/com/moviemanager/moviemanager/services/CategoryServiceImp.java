package com.moviemanager.moviemanager.services;

import com.moviemanager.moviemanager.model.Category;
import com.moviemanager.moviemanager.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public void addNewCategory(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public Category findById(Integer category_id) {
        return categoryRepository.findById(category_id).get();

    }
}


