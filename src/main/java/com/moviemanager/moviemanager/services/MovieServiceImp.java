package com.moviemanager.moviemanager.services;

import com.moviemanager.moviemanager.model.Movie;
import com.moviemanager.moviemanager.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImp implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies(){
        return this.movieRepository.findAll();
    }

    @Override
    public void addNewMovie(Movie movie) {
        this.movieRepository.save(movie);
    }

    @Override
    public Movie findByID(Integer id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public void deleteMovieById(Integer id) {
        movieRepository.delete(movieRepository.getById(id));
    }

}
