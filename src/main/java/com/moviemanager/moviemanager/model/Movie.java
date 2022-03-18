package com.moviemanager.moviemanager.model;

import javax.persistence.*;

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer movie_id;
    @Column(unique = true,length = 50)
    private  String movie_name;

    @OneToOne(mappedBy = "movie",cascade = CascadeType.ALL, orphanRemoval = true)
    private movie_category movie_category;


    public Movie() {
    }
    public Movie(Integer movie_id){
        this.movie_id=movie_id;
    }
    public  Movie(String movie_name, movie_category movie_category){
        this.movie_name=movie_name;
        this.movie_category=movie_category;
    }

    public Integer getMovie_id(){
       return movie_id;
   }


    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_category(movie_category movie_category){
        this.movie_category=movie_category;
    }
    public movie_category getMovie_category(){
        return  this.movie_category;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

}
