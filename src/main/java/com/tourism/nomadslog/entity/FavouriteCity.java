package com.tourism.nomadslog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Favcity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteCity {
    @Id
    private ObjectId id;
    private ObjectId cityId;
    private String cityName;
}
