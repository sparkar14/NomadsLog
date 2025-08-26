package com.tourism.nomadslog.repository;

import com.tourism.nomadslog.entity.TravelAnalysis;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TravelAnalysisRepository extends MongoRepository<TravelAnalysis, ObjectId> {
}
