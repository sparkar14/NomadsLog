package com.tourism.nomadslog.service;

import com.tourism.nomadslog.entity.Trip;
import com.tourism.nomadslog.repository.TripRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(Trip trip) { tripRepository.save(trip); }

    public List<Trip> getAll(){
        List<Trip> all  = tripRepository.findAll();
        return all;
    }

    public Trip getById(ObjectId id){ return tripRepository.findById(id).orElseThrow(() ->new RuntimeException("Trip not found with this id"+id)); }

    public void deleteById(ObjectId id){ tripRepository.deleteById(id); }


    // ✅ CORRECTED METHOD
    public List<Trip> getTripsByType(Trip.type type) {
        Query q = new Query(Criteria.where("tripType").is(type));
        return mongoTemplate.find(q, Trip.class); // Use instance, not class name
    }
    public void replacePhotoUrl(ObjectId tripId, String oldUrl, String newUrl) {
        Query query = new Query(Criteria.where("tripid").is(tripId)
                .and("photoUrls").is(oldUrl));

        Update update = new Update().set("photoUrls.$", newUrl);

        mongoTemplate.updateFirst(query, update, Trip.class);
    }
}
