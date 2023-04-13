package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movie {
    private int id;
    private String title;
    private String overview;
    private LocalDate releaseDate;
    private List<Person> cast;


    public Movie(int id, String title, String overview, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public List<Person> getCast() {
        return cast;
    }

    public void setCast(List<Person> cast) {
        this.cast = cast;
    }
}
