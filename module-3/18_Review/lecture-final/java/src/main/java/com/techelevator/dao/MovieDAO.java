package com.techelevator.dao;

import com.techelevator.model.Movie;

import java.util.List;

public interface MovieDAO {

    /**
     * fetch all the movies
     * @return a list of movies
     */
    List<Movie> getAll();

    /**
     * get a movie by its ID
     * @param id - the id of the movie to fetch
     * @return - the movie or NULL if the movie is not found
     */
    Movie getById(int id);
}
