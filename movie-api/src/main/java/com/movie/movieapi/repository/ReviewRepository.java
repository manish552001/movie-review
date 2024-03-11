package com.movie.movieapi.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movie.movieapi.modal.Reviews;

@Repository
public interface ReviewRepository extends MongoRepository<Reviews, ObjectId> {

}