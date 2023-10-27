package com.Himanshu.RatingService.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rating")
public class Ratings {

    private String userId;
    @Id
    private String ratingId;
    private String hotelId;
    private int rating;
    private String feedback;
}