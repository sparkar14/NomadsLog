package com.tourism.nomadslog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "trip_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    private ObjectId id;
    private ObjectId userId;
    private List<City> city;
    private LocalDate startDate;
    private LocalDate endDate;
    private int rating;
    private String description;
    private type triptype;
    private int Budget;
    private int spent;
    private List<String> companion;
    private Season season;
    //Optional
    private List<String> photoUrls;

    public enum Season{
        SUMMER , WINTER , AUTUMN , SPRING;
    }

    public enum type {
        BUSINESS , SOLO , FAMILY, FRIENDS , BAKCHODI , RANDOM , GANDMKHUJLI;
    }


}
