package com.Hotel.Module.Service;

import com.Hotel.Module.Entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    public Hotel saveHotel(Hotel hotel);

    public List<Hotel>getAllHotels();

    public Optional<Hotel> getHotelById(long hotelId);



}
