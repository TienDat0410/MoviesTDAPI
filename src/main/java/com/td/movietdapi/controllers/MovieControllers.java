package com.td.movietdapi.controllers;

import com.td.movietdapi.models.Movie;
import com.td.movietdapi.models.MovieDetails;
import com.td.movietdapi.repositories.MovieRepository;
import com.td.movietdapi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieControllers {
    @Autowired
    private MovieService movieService;


    @GetMapping
    public ResponseEntity<List<Movie>> getNowPlayingMovies() {
        List<Movie> movies = movieService.getMovieNowPlay();
        if (!movies.isEmpty()) {
            return ResponseEntity.ok(movies);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
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
