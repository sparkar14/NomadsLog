package com.tourism.nomadslog.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection="travel-stats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelAnalysis {
    @Id
    private ObjectId id;
    private ObjectId userid;
    private int totConVisit;
    private int totCityVisit;
    private int totTripTaken;
    private int totalTravelDays;
    private Map<Trip.type, Long> TripTypeDis;
    private List<String> MostConVisit;
    private double avgRating;
}
