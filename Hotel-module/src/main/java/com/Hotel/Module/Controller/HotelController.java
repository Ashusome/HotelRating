package com.Hotel.Module.Controller;

import com.Hotel.Module.Entity.Hotel;
import com.Hotel.Module.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

@PostMapping
    public ResponseEntity<Hotel>saveHotel(@RequestBody Hotel hotel) {
    Hotel hotel1 = hotelService.saveHotel(hotel);
    return new ResponseEntity<>(hotel1, HttpStatus.CREATED);

}
    @GetMapping
    public ResponseEntity<List<Hotel>>getAllHotels(){
        List<Hotel> allHotels = hotelService.getAllHotels();
        return new ResponseEntity<>(allHotels, HttpStatus.OK);
    }
@GetMapping("/{hotelId}")
    public ResponseEntity<Optional<Hotel>>getHotelById(@PathVariable Long hotelId){
        Optional<Hotel> hotelById = hotelService.getHotelById(hotelId);
        return new ResponseEntity<>(hotelById, HttpStatus.OK);
    }




}
