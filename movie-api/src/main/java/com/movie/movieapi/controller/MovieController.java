package com.movie.movieapi.controller;

// import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.movie.movieapi.modal.Movie;
import com.movie.movieapi.services.MovieService;

// import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    public MovieService servies;





//SWAGGER_UI--------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

//    @RequestMapping (value ="/")
// 	public void redirect (HttpServletResponse response) throws IOException {
// 	response.sendRedirect("/swagger-ui.html");
// 	}
//SWAGGER_UI--------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>





    
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        return new ResponseEntity<List<Movie>>(servies.findAllMovies(),HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> searchMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(servies.findMovieByImdbId(imdbId), HttpStatus.OK);
    }

}
