package com.td.movietdapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetails {
    private boolean adult;
    private String backdropPath;
    private Object belongsToCollection;
    private long budget;
    private List<Genre> genres;
    private String homepage;
    private int id;
    private String imdbId;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private double popularity;
    private String posterPath;
    private List<ProductionCompany> productionCompanies;
    private List<ProductionCountry> productionCountries;
    private String releaseDate;
    private long revenue;
    private int runtime;
    private List<SpokenLanguage> spokenLanguages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private double voteAverage;
    private int voteCount;

    // Nested classes

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Genre {
        private int id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductionCompany {
        private int id;
        private String logoPath;
        private String name;
        private String originCountry;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductionCountry {
        private String iso_3166_1;
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SpokenLanguage {
        private String englishName;
        private String iso_639_1;
        private String name;
    }
}
