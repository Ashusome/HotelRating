package com.RatingModule.Controller;

import com.RatingModule.Entity.Rating;
import com.RatingModule.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    @Autowired
    private RatingService service;
    @PostMapping
    public ResponseEntity<Rating>createRating(@RequestBody Rating rating){
        Rating rating1 = service.createRating(rating);
        return new ResponseEntity<>(rating1, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Rating>>getAllRating(){
        List<Rating> allRating = service.getAllRating();
        return new ResponseEntity<>(allRating, HttpStatus.OK);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>>getAllRatingsByUserId(@PathVariable String userId){
        List<Rating> allRatingsByUserId = service.getAllRatingsByUserId(userId);
        return new ResponseEntity<>(allRatingsByUserId, HttpStatus.OK);
    }
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>>getAllRatingsByHotelId(@PathVariable String hotelId){
    List<Rating> allRatingByHotelId = service.getAllRatingByHotelId(hotelId);
    return new ResponseEntity<>( allRatingByHotelId, HttpStatus.OK);
  }


}
