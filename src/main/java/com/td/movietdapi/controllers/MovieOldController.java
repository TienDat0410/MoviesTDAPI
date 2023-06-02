package com.td.movietdapi.controllers;

import com.td.movietdapi.services.MovieOldService;
import com.td.movietdapi.models.MovieOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/moviesold")
public class MovieOldController {

    @Autowired
    private MovieOldService movieOldService;

    @GetMapping
    public ResponseEntity<List<MovieOld>> getAllMovies(){
        return new ResponseEntity<List<MovieOld>>(movieOldService.finfAllMovies(), HttpStatus.OK);
    }
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<MovieOld>> getSigleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<MovieOld>>(movieOldService.singleMovie(imdbId), HttpStatus.OK);
    }
}
