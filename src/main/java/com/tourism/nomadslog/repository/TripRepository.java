package com.tourism.nomadslog.repository;

import com.tourism.nomadslog.entity.Trip;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TripRepository extends MongoRepository<Trip , ObjectId> {

    @Query("{'type': ?0}")
    List<Trip> findTripByType(Trip.type type);

    List<Trip> findByUserId(ObjectId userId);
}
