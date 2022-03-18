package com.moviemanager.moviemanager.services;

import com.moviemanager.moviemanager.model.movie_category;

import java.util.List;

public interface Movie_CategoryService {
    List<movie_category> getAllMovie_Categories();
    void addNewMovie_Category(movie_category movie_category);
}
