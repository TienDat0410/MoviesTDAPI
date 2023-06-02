package com.td.movietdapi.services;

import com.td.movietdapi.models.Movie;
import com.td.movietdapi.models.MovieDetails;
import com.td.movietdapi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MovieService {

    private final String tmdbApiKey;
    private final String tmdbBaseUrl;

    @Autowired
    private final MovieRepository movieRepository;
    private final WebClient webClient;
    public MovieService(MovieRepository movieRepository,
                        @Value("${TMDB_KEY}") String tmdbApiKey,
                        @Value("${TMDB_BASE_URL}") String tmdbBaseUrl, WebClient.Builder webClientBuilder)
    {
        this.webClient = webClientBuilder.baseUrl(tmdbBaseUrl).build();
        this.movieRepository = movieRepository;
        this.tmdbApiKey = tmdbApiKey;
        this.tmdbBaseUrl = tmdbBaseUrl;
    }

    public MovieDetails getMovieDetails(int movieId){
        Movie movie = movieRepository.getMovieById(movieId);
        if (movie != null) {
            String url = "/movie/" + movieId + "?api_key=" + tmdbApiKey;
            return webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(MovieDetails.class)
                    .block();
        } else {
            System.out.printf("loi roi ma!!");
            return null;
        }
    }

}
