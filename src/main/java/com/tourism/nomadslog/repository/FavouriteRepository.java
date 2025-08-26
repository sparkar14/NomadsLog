package com.tourism.nomadslog.repository;

import com.tourism.nomadslog.entity.FavouriteCity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FavouriteRepository extends MongoRepository<FavouriteCity, ObjectId> {

}
