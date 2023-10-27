package com.Himanshu.HotelService.services;

import com.Himanshu.HotelService.Models.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel create(Hotel hotel);

    public List<Hotel> getAll();

    public Hotel getbyId(String id);
}
