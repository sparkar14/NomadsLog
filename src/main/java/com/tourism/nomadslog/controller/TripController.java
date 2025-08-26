package com.tourism.nomadslog.controller;

import com.tourism.nomadslog.entity.Trip;
import com.tourism.nomadslog.service.TripService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/trips")
@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping
    public ResponseEntity<?> AllTrip(){
       List<Trip> all = tripService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> TripById(@PathVariable ObjectId id){
        Trip tp = tripService.getById(id);
        return new ResponseEntity<>(tp, HttpStatus.OK);
    }
    @GetMapping("/by-type/{type}")
    public ResponseEntity<?> findTripByType(@PathVariable Trip.type type){
        List<Trip> tt = tripService.getTripsByType(type);
        return new ResponseEntity<>(tt, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTrip(@PathVariable ObjectId id){
        tripService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> addTrip(@RequestBody Trip trip){
        tripService.save(trip);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateTrip(@RequestBody Trip trip){
        Trip tp = tripService.getById(trip.getId());
        tp.setDescription(trip.getDescription());
        return new ResponseEntity<>(tp, HttpStatus.ACCEPTED);
    }
    //PHOTOS
    //add photos
    @PostMapping("{tripid}/photos")
    public ResponseEntity<?> addPhotos(@PathVariable ObjectId tripid, @RequestParam String photoUrls){
        Trip trip = tripService.getById(tripid);
        if(trip!=null){
            if(trip.getPhotoUrls()==null){
                trip.setPhotoUrls(new ArrayList<>());
            }
            trip.getPhotoUrls().add(photoUrls);
            tripService.save(trip);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>("Trip not found",HttpStatus.NOT_FOUND);
    }
    //delete photos
    @DeleteMapping("{tripid}/photos")
    public ResponseEntity<?> deletePhotos(@PathVariable ObjectId tripid, @RequestParam String photoUrls){
        Trip trip = tripService.getById(tripid);
        if(trip!=null){
            if(trip.getPhotoUrls()!=null){
                trip.getPhotoUrls().remove(photoUrls);
            }
            tripService.save(trip);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>("Trip not found",HttpStatus.NOT_FOUND);
    }
    //update photos
    @PutMapping("{tripid}/photos/{photoid}")
    public ResponseEntity<?> updatePhotos(@PathVariable ObjectId tripid, @PathVariable String photoid,@RequestParam String photoUrls){
        Trip trip = tripService.getById(tripid);
        if(trip!=null){
            if(trip.getPhotoUrls()!=null){
                tripService.replacePhotoUrl(tripid,photoid,photoUrls);
            }
            tripService.save(trip);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Trip not found",HttpStatus.NOT_FOUND);
    }

}
