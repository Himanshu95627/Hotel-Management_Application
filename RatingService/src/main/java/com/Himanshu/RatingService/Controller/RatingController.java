package com.Himanshu.RatingService.Controller;

import com.Himanshu.RatingService.Models.Ratings;
import com.Himanshu.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping()
    public ResponseEntity<Ratings> createRating(@RequestBody Ratings ratings) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(ratings));
    }
    @GetMapping
    public ResponseEntity<List<Ratings>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAll());
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Ratings>> getByHotelId(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.FOUND).body(ratingService.getAllbyHotelId(hotelId));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Ratings>> getByUserId(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.FOUND).body(ratingService.getAllbyUserId(userId));
    }
}
