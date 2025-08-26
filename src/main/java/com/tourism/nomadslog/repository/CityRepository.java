package com.tourism.nomadslog.repository;

import com.tourism.nomadslog.entity.City;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CityRepository extends MongoRepository<City, ObjectId> {

    List<City> findByTags(String tags);
}
