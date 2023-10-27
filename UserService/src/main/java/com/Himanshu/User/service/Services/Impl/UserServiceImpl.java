package com.Himanshu.User.service.Services.Impl;

import com.Himanshu.User.service.Exception.ResourceNotFoundException;

import com.Himanshu.User.service.Models.Hotel;
import com.Himanshu.User.service.Models.Ratings;
import com.Himanshu.User.service.Models.UserClass;
import com.Himanshu.User.service.Repositories.UserRepository;
import com.Himanshu.User.service.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserClass saveUser(UserClass userClass) {
        userClass.setUserId(UUID.randomUUID().toString());
        return userRepository.save(userClass);
    }

    @Override
    public List<UserClass> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserClass getUser(String userId) {
        Optional<UserClass> optional = userRepository.findById(userId);
        Ratings[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + userId, Ratings[].class);

        List<Ratings> collect = Arrays.stream(ratings).collect(Collectors.toList());
        List<Ratings> collect1 = collect.stream().map(ratings1 -> {
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + ratings1.getHotelId(), Hotel.class);
            Hotel body = forEntity.getBody();
            ratings1.setHotel(body);
            return ratings1;
        }).collect(Collectors.toList());

        if (optional.isPresent()) {
            UserClass userClass = optional.get();
            userClass.setRatings(collect1);
            return userClass;
        }
        throw new ResourceNotFoundException("no resource found");
    }

    @Override
    public UserClass updateUser(UserClass userClass) {
        return userRepository.save(userClass);
    }

    @Override
    public void deleteUser(UserClass userClass) {
        userRepository.delete(userClass);
    }
}
