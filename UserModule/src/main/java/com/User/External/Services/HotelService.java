package com.User.External.Services;

import com.User.Entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-MODULE")
public interface HotelService
{
    @GetMapping("/api/hotel/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);

}


