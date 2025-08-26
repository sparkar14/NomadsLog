package com.tourism.nomadslog.repository;

import com.tourism.nomadslog.entity.LogsDB;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogsDBRepository extends MongoRepository<LogsDB , ObjectId> {
}
