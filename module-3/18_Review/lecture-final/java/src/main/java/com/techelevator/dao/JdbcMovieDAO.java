package com.techelevator.dao;

import com.techelevator.model.Movie;
import com.techelevator.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMovieDAO implements MovieDAO {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getAll() {

        final String sql = "SELECT movie_id, title, overview, release_date\n" +
                "FROM movie\n" +
                "ORDER BY title, release_date;\n";

        final SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sql);
        List<Movie> movies = new ArrayList<>();
        while (rs.next()) {
            final Movie movie = mapRowToMovie(rs);
            movies.add(movie);
        }

        return movies;
    }

    private Movie mapRowToMovie(SqlRowSet rs) {
        final int id = rs.getInt("movie_id");
        final String title = rs.getString("title");
        final String overview = rs.getString("overview");
        LocalDate releaseDate = null;
        if (rs.getDate("release_date") != null) {
            releaseDate = rs.getDate("release_date").toLocalDate();
        }

        final Movie movie = new Movie(id, title, overview, releaseDate);
        return movie;
    }

    @Override
    public Movie getById(int id) {
        final String sql = "SELECT movie_id, title, overview, release_date\n" +
                "FROM movie\n" +
                "WHERE movie_id = ?;";

        final String castSql = "SELECT person_id, person_name\n" +
                "FROM person p INNER JOIN movie_actor ma ON p.person_id = ma.actor_id\n" +
                "WHERE ma.movie_id = ?\n" +
                "ORDER BY person_name;";

        final SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sql, id);
        if (! rs.next()) {
            return null;
        }
        final Movie movie = this.mapRowToMovie(rs);

        final SqlRowSet castRs = this.jdbcTemplate.queryForRowSet(castSql, id);
        List<Person> cast = new ArrayList<>();
        while (castRs.next()) {
            final int castid = castRs.getInt("person_id");
            final String name = castRs.getString("person_name");
            final Person person = new Person(castid, name);
            cast.add(person);
        }

        movie.setCast(cast);
        return movie;
    }
}
