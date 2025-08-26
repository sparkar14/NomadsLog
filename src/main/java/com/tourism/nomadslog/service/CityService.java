package com.tourism.nomadslog.service;

import com.tourism.nomadslog.entity.City;
import com.tourism.nomadslog.entity.FavouriteCity;
import com.tourism.nomadslog.repository.CityRepository;
import com.tourism.nomadslog.repository.FavouriteRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private FavouriteRepository favouriteRepository;

    @Autowired
    private WishlistRepository wishlistRepository;

    public void save(City city) { this.cityRepository.save(city); }

    public City CityEntry(City city) {
  City cityEntry = new City();
      cityEntry.setName(city.getName());
      cityEntry.setCountry(city.getCountry());
      cityEntry.setDetails(city.getDetails());
      cityRepository.save(cityEntry);
      return cityEntry;
    }

    public List<City> CityList() {
       List<City> cc =  cityRepository.findAll();
       return cc;
    }
    public City findCityByName(ObjectId id) {return cityRepository.findById(id).orElseThrow(() -> new RuntimeException("city not found with id: " + id.toString()));}

    public void DeleteById(ObjectId id) {cityRepository.deleteById(id);}

    public List<City> getCityByTags(String tags) {
        List<City> all = cityRepository.findByTags(tags);
        return all;
    }

    public FavouriteCity addFavourite(ObjectId id,String name) {
        return favouriteRepository.save(new FavouriteCity(null,id,name));
    }

    public List<FavouriteCity> getALlFavCity(){
       List<FavouriteCity> n = favouriteRepository.findAll();
       return n;
    }

}
