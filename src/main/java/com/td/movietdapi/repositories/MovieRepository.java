package com.td.movietdapi.repositories;

import com.td.movietdapi.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository {

    Movie getMovieById(int movieId);
}
