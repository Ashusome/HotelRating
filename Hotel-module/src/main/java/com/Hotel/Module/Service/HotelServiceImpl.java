package com.Hotel.Module.Service;

import com.Hotel.Module.Entity.Hotel;
import com.Hotel.Module.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        Hotel savedHotel = hotelRepository.save(hotel);
        return savedHotel;
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> allHotels = hotelRepository.findAll();
        return allHotels;
    }

    @Override
    public Optional<Hotel> getHotelById(long hotelId) {
        Optional<Hotel>hotelbyId = hotelRepository.findById(hotelId);
        return hotelbyId;
    }
}
