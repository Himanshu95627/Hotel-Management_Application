package com.Himanshu.RatingService.Service;

import com.Himanshu.RatingService.Models.Ratings;

import java.util.List;

public interface RatingService {

    // create
    Ratings createRating(Ratings ratings);
    //get all
    List<Ratings> getAll();
    // get all by userID
    List<Ratings> getAllbyUserId(String userId);
    // get all by hotel id
    List<Ratings> getAllbyHotelId(String HotelId);
}
