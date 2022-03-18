package com.moviemanager.moviemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer category_id;
    @Column(nullable = false,unique = true,length = 50)
    private String category_name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<movie_category> movie_categories = new HashSet<>();


    public Category() {
    }

    public Category(String category_name,Set<movie_category> movie_categorys){
        this.category_name=category_name;
        this.movie_categories=movie_categorys;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void  setMovie_categories(Set<movie_category> movie_categories){
        this.movie_categories=movie_categories;
    }

    public Set<movie_category> getMovie_categories() {
        return movie_categories;
    }
}
