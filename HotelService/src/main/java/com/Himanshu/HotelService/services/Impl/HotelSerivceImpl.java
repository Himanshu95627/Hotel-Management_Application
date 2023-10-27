package com.Himanshu.HotelService.services.Impl;

import com.Himanshu.HotelService.Models.Hotel;
import com.Himanshu.HotelService.Repository.HotelRepository;
import com.Himanshu.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelSerivceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        hotel.setId(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getbyId(String id) {
        return hotelRepository.findById(id).get();
    }
}
