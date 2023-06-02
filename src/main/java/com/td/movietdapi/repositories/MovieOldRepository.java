package com.td.movietdapi.repositories;

import com.td.movietdapi.models.MovieOld;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieOldRepository extends MongoRepository<MovieOld, ObjectId> {
    Optional<MovieOld> findMovieByImdbId(String imdbId);
}
