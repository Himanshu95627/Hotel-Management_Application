package com.Himanshu.RatingService.repository;

import com.Himanshu.RatingService.Models.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Ratings,String> {

    List<Ratings> findByUserId(String userId);
    List<Ratings> findByHotelId(String hotelId);
}
