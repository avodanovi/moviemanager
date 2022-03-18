package com.moviemanager.moviemanager.services;

import com.moviemanager.moviemanager.model.Movie;


import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    void addNewMovie(Movie movie);
    Movie findByID(Integer id);
    void deleteMovieById(Integer id);
}
