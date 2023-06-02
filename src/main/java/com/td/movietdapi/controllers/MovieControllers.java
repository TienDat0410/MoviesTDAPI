package com.td.movietdapi.controllers;

import com.td.movietdapi.models.MovieDetails;
import com.td.movietdapi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieControllers {
    @Autowired
    private MovieService movieService;

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDetails> getMovieDetails(@PathVariable int movieId) {
        MovieDetails movie = movieService.getMovieDetails(movieId);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
