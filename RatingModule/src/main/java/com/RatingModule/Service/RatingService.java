package com.RatingModule.Service;

import com.RatingModule.Entity.Rating;

import java.util.List;

public interface RatingService {

    public Rating createRating(Rating rating);

    public List<Rating>getAllRating();

    public List<Rating> getAllRatingsByUserId(String userId);

    public List<Rating>getAllRatingByHotelId(String hotelId);

}
