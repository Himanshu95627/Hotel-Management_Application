package com.Himanshu.User.service.Models;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ratings {

    private String userId;
    private String ratingId;
    private String hotelId;
    private int rating;
    private String feedback;

    private Hotel hotel;
}
