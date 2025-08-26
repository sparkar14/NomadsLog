package com.tourism.nomadslog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    private ObjectId id;
    private String name;
    private String country;
    private String details;
    //NEW FEATURES
    private List<String> tags;
    private boolean isFav;
    private boolean isOnWish;
    private Integer priorityList;


}

