package com.td.movietdapi.services;

import com.td.movietdapi.models.Movie;
import com.td.movietdapi.models.MovieDetails;
import com.td.movietdapi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Service
public class MovieService {

    private final String tmdbApiKey;
    private final String tmdbBaseUrl;

    private MovieRepository movieRepository;

    private final WebClient webClient;
    public MovieService(@Value("${TMDB_KEY}") String tmdbApiKey, @Value("${TMDB_BASE_URL}") String tmdbBaseUrl, WebClient.Builder webClientBuilder)
    {
        this.webClient = webClientBuilder.baseUrl(tmdbBaseUrl).build();
        this.tmdbApiKey = tmdbApiKey;
        this.tmdbBaseUrl = tmdbBaseUrl;
    }

    public List<Movie> getMovieNowPlay(){
        String url = "/movie/now_playing" + "?api_key=" + tmdbApiKey;
        movieRepository = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(MovieRepository.class)
                .block();
        if (movieRepository != null) {
            return movieRepository.getResults();
        } else {
            return Collections.emptyList();
        }
    }

    public MovieDetails getMovieDetails(int movieId){
            String url = "/movie/" + movieId + "?api_key=" + tmdbApiKey;
            return webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(MovieDetails.class)
                    .block();

    }

}
