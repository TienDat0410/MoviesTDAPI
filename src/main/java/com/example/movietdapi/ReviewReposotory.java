package com.example.movietdapi;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewReposotory extends MongoRepository<Review, ObjectId> {
}
