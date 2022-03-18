package com.moviemanager.moviemanager.repositories;

import com.moviemanager.moviemanager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
