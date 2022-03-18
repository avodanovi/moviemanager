package com.moviemanager.moviemanager.repositories;

import com.moviemanager.moviemanager.model.movie_category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Movie_CategoryRepository extends JpaRepository<movie_category,Integer> {
}
