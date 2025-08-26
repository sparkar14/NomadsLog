package com.tourism.nomadslog.service;

import com.tourism.nomadslog.entity.Trip;
import com.tourism.nomadslog.repository.TravelAnalysisRepository;
import com.tourism.nomadslog.repository.TripRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class TravelService {

    @Autowired
    private TravelAnalysisRepository travelAnalysisRepository;
    @Autowired
    private TripRepository tripRepository;

    public void UserStats(ObjectId id){

       List<Trip> trips = tripRepository.findByUserId(id);
       int totalTrips = trips.size();

      /*  // total days travelled
        long totalDays = trips.stream()
                .mapToLong(trip -> DAYS.between(
                        trip.getStartDate(),
                        trip.getEndDate()))
                .sum();
             */
    }
}
