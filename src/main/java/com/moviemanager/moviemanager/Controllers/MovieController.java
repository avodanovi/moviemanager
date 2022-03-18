package com.moviemanager.moviemanager.Controllers;
import com.moviemanager.moviemanager.HelpClasses.MovieDetails;
import com.moviemanager.moviemanager.model.Category;
import com.moviemanager.moviemanager.model.Movie;
import com.moviemanager.moviemanager.model.movie_category;
import com.moviemanager.moviemanager.services.CategoryService;
import com.moviemanager.moviemanager.services.MovieService;
import com.moviemanager.moviemanager.services.Movie_CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private CategoryService categoryService;
    //display list of movies
    @Autowired
    private Movie_CategoryService movie_categoryService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        System.out.println(categoryService.getAllCategories());
        model.addAttribute("moviesList",movieService.getAllMovies());
        model.addAttribute("categoryList",categoryService.getAllCategories());
        return "index";
    }
    @GetMapping("/new_movie")
    public String addNewMovie(Model model){
        model.addAttribute("movieDetails",new MovieDetails());
        model.addAttribute("categoryList",categoryService.getAllCategories());

        return  "new_movie";

    }
    @PostMapping("/index/editmovie")
    public String editMovie(@ModelAttribute("movieDetails") MovieDetails movieDetails){
        Movie movie = movieService.findByID(movieDetails.getMovie_id());
        movieService.deleteMovieById(movie.getMovie_id());
        movie.setMovie_name(movieDetails.getMovie_name());
        movie.getMovie_category().setCategory(categoryService.findById((movieDetails.getCategory_id())));
        movieService.addNewMovie(movie);
        return "redirect:/";
    }

    @PostMapping("/index/addmovie")
    public String addNewMovie(@ModelAttribute("movieDetails") MovieDetails movieDetails){
        Movie movie = new Movie();
        movie.setMovie_name(movieDetails.getMovie_name());
        movie_category movie_category= new movie_category();
        movie_category.setMovie(movie);
        movie_category.setCategory(categoryService.findById(movieDetails.getCategory_id()));
        movie.setMovie_category(movie_category);
        //save movie to database
        movieService.addNewMovie(movie);
        return "redirect:/";
    }

    @PostMapping("/index/addcategory")
    public String addNewCategory(Category category){
        categoryService.addNewCategory(category);
        return "redirect:/";
    }

    @GetMapping("/new_category")
    public String showCategoryNewForm(Model model){
        model.addAttribute("category",new Category());
        return "new_category";
    }

     @GetMapping("edit_movie/{id}")
    public String showEditMovieForm(@PathVariable("id") Integer id,Model model){
        Movie movie = movieService.findByID(id);
        MovieDetails movieDetails = new MovieDetails(movie.getMovie_name(),movie.getMovie_category().getCategory().getCategory_id(),movie.getMovie_id());
        model.addAttribute("movieDetails",movieDetails);
        model.addAttribute("categoryList",categoryService.getAllCategories());

         return "edit_movie";
     }

     @GetMapping("edit_category/{id}")
     public String showEditCategoryForm(@PathVariable("id") Integer id,Model model){
        Category category =categoryService.findById(id);
        model.addAttribute("category",category);

         return "edit_category";
     }

     @GetMapping("delete_movie/{id}")
    public String deleteMovie(@PathVariable Integer id){
        movieService.deleteMovieById(id);
        return "redirect:/";
     }

}
