package com.techelevator.controller;

import com.techelevator.dao.MovieDAO;
import com.techelevator.model.Movie;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MoviesController {

    private final MovieDAO movieDAO;

    public MoviesController(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @GetMapping("/movies")
    public List<Movie> getAll() {
        return this.movieDAO.getAll();
    }

    @GetMapping("/movies/{id}")
    public Movie getById(@PathVariable int id) {
        return this.movieDAO.getById(id);
    }

}
