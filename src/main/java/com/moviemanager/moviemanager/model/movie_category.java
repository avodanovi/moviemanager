package com.moviemanager.moviemanager.model;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="movie_category")
public class movie_category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movie_category_id;
    @OneToOne
    @JoinColumn(name="movie_id", referencedColumnName = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName = "category_id")
    private Category category;

    public movie_category() {
    }


    public movie_category(Movie movie, Category category){
        this.movie = movie;
        this.category= category;
    }

    public Category getCategory() {
        return category;
    }

    public Movie getMovie() {
        return movie;
    }

    public void  setMovie(Movie movie){
        this.movie=movie;
    }
    public void setCategory(Category category){
        this.category=category;
    }

}
