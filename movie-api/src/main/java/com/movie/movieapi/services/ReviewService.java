package com.movie.movieapi.services;

// import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.movie.movieapi.modal.Movie;
import com.movie.movieapi.modal.Reviews;
import com.movie.movieapi.repository.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;
   
    @Autowired
    private MongoTemplate mongoTemplate;

    public Reviews createReview(String reviewBody, String imdbId) {

        // Reviews review = repository.insert(new Reviews(reviewBody, LocalDateTime.now(), LocalDateTime.now()));
        Reviews review = repository.insert(new Reviews(reviewBody));
        

        mongoTemplate.update(Movie.class)
            .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review.getId()))
                .first();
        return review;
    }
}