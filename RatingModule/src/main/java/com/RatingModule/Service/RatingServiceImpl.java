package com.RatingModule.Service;

import com.RatingModule.Entity.Rating;
import com.RatingModule.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating createRating(Rating rating) {
        String string = UUID.randomUUID().toString();
        rating.setRatingId(rating.getRatingId());
        Rating savedRating = ratingRepository.save(rating);
        return savedRating;
    }

    @Override
    public List<Rating> getAllRating() {
        List<Rating> allRatings = ratingRepository.findAll();
        return allRatings;
    }

    @Override
    public List<Rating> getAllRatingsByUserId(String userId) {
        List<Rating> byUserId = ratingRepository.findByUserId(userId);
        return byUserId;
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String hotelId) {
        List<Rating> byHotelId = ratingRepository.findByHotelId(hotelId);
        return byHotelId;
    }
}
