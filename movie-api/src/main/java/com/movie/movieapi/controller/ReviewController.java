package  com.movie.movieapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.movie.movieapi.modal.Reviews;
import com.movie.movieapi.services.ReviewService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService service;

    @PostMapping()
    public ResponseEntity<Reviews> createReview(@RequestBody Map<String, String> payload) {
        String reviewIds = payload.get("reviewIds");
        String imdbId = payload.get("imdbId");
        return new ResponseEntity<Reviews>(service.createReview(reviewIds, imdbId), HttpStatus.OK);
    }
}