package com.tourism.nomadslog.repository;

import entity.Trip;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepository extends MongoRepository<Trip , ObjectId> {
}
