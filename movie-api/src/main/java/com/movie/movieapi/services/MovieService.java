package com.movie.movieapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.movieapi.modal.Movie;
import com.movie.movieapi.repository.MovieRepositery;

@Service
public class MovieService {

    @Autowired
    private MovieRepositery movieRepositery;
    public List<Movie> findAllMovies() {
        return movieRepositery.findAll();
    }
    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return movieRepositery.findMovieByImdbId(imdbId);
    }

    // public Movie saveMovie(Movie movie) {
    //     return movieRepositery.save(movie);
    // }
}
