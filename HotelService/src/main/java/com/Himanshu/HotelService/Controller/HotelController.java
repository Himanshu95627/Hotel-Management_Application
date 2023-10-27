package com.Himanshu.HotelService.Controller;

import com.Himanshu.HotelService.Models.Hotel;
import com.Himanshu.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    // create
    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    // get single

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> create(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getbyId(hotelId));
    }


    // get all

    @GetMapping()
    public ResponseEntity<List<Hotel>> create(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
    }

}
