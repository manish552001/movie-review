package com.movie.movieapi.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movie.movieapi.modal.Movie;


@Repository
public interface MovieRepositery extends MongoRepository<Movie,ObjectId> {
    Optional<Movie> findMovieByImdbId(String imdbId);
    
}
