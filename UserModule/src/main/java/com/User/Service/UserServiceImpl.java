package com.User.Service;

import com.User.Entity.Hotel;
import com.User.Entity.Rating;
import com.User.Entity.User;
import com.User.External.Services.HotelService;
import com.User.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User saveUser( User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(user.getUserId());
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public User getUserById(String userId) {
        User user = userRepository.findById(userId).get();
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGMODULE/api/ratings/users/" + user.getUserId(), Rating[].class);
        logger.info("{}",ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        ratings.stream().map(rating -> {
//                    ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-MODULE/api/hotel/"+rating.getHotelId(), Hotel.class);
                    Hotel hotel = hotelService.getHotel((rating.getHotelId()));
            rating.setHotel(hotel);
            return rating;
                }).collect(Collectors.toList());

        user.setRating((Rating)ratings);

        return user;

    }
}
