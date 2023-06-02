package com.td.movietdapi.repositories;

import com.td.movietdapi.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRepository{

    private List<Movie> results;
}
