package com.tourism.nomadslog.controller;

import com.tourism.nomadslog.entity.City;
import com.tourism.nomadslog.entity.FavouriteCity;
import com.tourism.nomadslog.entity.Trip;
import com.tourism.nomadslog.service.CityService;
import com.tourism.nomadslog.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<?> newCity(@RequestBody City city) {
        City cityadd = cityService.CityEntry(city);
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getAllCity() {
    List<City> list= cityService.CityList();
    if(list.isEmpty())
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCityById(@PathVariable ObjectId id) {
       City city = cityService.findCityByName(id);
       return new ResponseEntity<>(city, HttpStatus.OK);
    }
    @GetMapping("/by-type/{tags}")
    public ResponseEntity<?> findCityByTags(@PathVariable String tags) {
        List<City> tt = cityService.getCityByTags(tags);
        return new ResponseEntity<>(tt, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateCity(@RequestBody City city) {
     City updatecity = cityService.findCityByName(city.getId());
     updatecity.setName(city.getName());
     updatecity.setCountry(city.getCountry());
     updatecity.setDetails(city.getDetails());
     cityService.save(updatecity);
     return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCityById(@PathVariable ObjectId id) {
        cityService.DeleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Favourite Cities
    @PostMapping("/fav/{id}")
    public ResponseEntity<?> addFavCity(@PathVariable ObjectId id,@RequestBody String name) {
     return new ResponseEntity<>(cityService.addFavourite(id,name),HttpStatus.CREATED);
    }
    @GetMapping("/fav")
    public ResponseEntity<?> getFavCity() {
        return new ResponseEntity<>(cityService.getALlFavCity(),HttpStatus.OK);
    }

}
