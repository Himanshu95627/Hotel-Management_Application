package com.Himanshu.RatingService.Service.Impl;

import com.Himanshu.RatingService.Models.Ratings;
import com.Himanshu.RatingService.Service.RatingService;
import com.Himanshu.RatingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Ratings createRating(Ratings ratings) {
        ratings.setRatingId(UUID.randomUUID().toString());
        return ratingRepository.save(ratings);
    }

    @Override
    public List<Ratings> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Ratings> getAllbyUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Ratings> getAllbyHotelId(String HotelId) {
        return ratingRepository.findByHotelId(HotelId);
    }
}
