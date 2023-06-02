package com.td.movietdapi.services;

import com.td.movietdapi.models.MovieOld;
import com.td.movietdapi.repositories.MovieOldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieOldService {
    @Autowired
    private MovieOldRepository movieOldRepository;
    public List<MovieOld> finfAllMovies(){

        return movieOldRepository.findAll();
    }

    public Optional<MovieOld> singleMovie(String imdbId){
        return movieOldRepository.findMovieByImdbId(imdbId);
    }
}
