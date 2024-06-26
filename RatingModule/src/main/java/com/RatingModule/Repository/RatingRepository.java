package com.RatingModule.Repository;

import com.RatingModule.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUserId(String userId);

    List<Rating>findByHotelId(String hotelId);
}
