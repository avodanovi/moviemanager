package com.moviemanager.moviemanager.HelpClasses;

public class MovieDetails {
    private String movie_name;
    private Integer category_id;
    private Integer movie_id;

    public MovieDetails(){}
    public MovieDetails(Integer movie_id){
        this.movie_id=movie_id;
    }
    public MovieDetails(String movie_name, Integer category_id,Integer movie_id) {
        this.movie_name = movie_name;
        this.category_id = category_id;
        this.movie_id=movie_id;
    }

    public String getMovie_name() {
        return this.movie_name;
    }
    public  void setMovie_name(String movie_name){
        this.movie_name=movie_name;
    }
    public Integer getCategory_id(){
        return this.category_id;
    }
    public void setCategory_id(Integer category_id){
        this.category_id=category_id;
    }
    public Integer getMovie_id(){
        return this.movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }
}
