package com.RatingModule.Entity;

import com.Hotel.Module.Entity.Hotel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Ratings")
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ratingId;
    @Column(name = "HotelId")
    private String hotelId;
    @Column(name = "UserId")
    private String userId;
    @Column(name = "Rating")
    private int rating;
    @Column(name = "FeedBack")
    private String feedback;

}
