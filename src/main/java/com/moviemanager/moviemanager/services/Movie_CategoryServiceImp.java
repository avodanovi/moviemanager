package com.moviemanager.moviemanager.services;

import com.moviemanager.moviemanager.model.movie_category;
import com.moviemanager.moviemanager.repositories.Movie_CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Movie_CategoryServiceImp implements Movie_CategoryService{

    @Autowired
    Movie_CategoryRepository movie_categoryRepository;

    @Override
    public List<movie_category> getAllMovie_Categories() {
       return this.movie_categoryRepository.findAll();
    }

    @Override
    public void addNewMovie_Category(movie_category movie_category) {
        this.movie_categoryRepository.save(movie_category);
    }
}
