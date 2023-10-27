package com.Himanshu.User.service.Controller;

import com.Himanshu.User.service.Models.UserClass;
import com.Himanshu.User.service.Services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<UserClass> createUser(@RequestBody UserClass user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }
    int retryCount=1;
    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "RatingHotelFallback")
//    @Retry(name = "ratingHotelRetry",fallbackMethod = "RatingHotelFallback")
      @RateLimiter(name = "hotelratingRatelimiter", fallbackMethod = "RatingHotelFallback")
    public ResponseEntity<UserClass> getSingleUser(@PathVariable("userId") String userId){
        log.info("Calling getsingleUser with retry count : "+retryCount);
        retryCount++;
        UserClass user = userService.getUser(userId);

        return ResponseEntity.ok(user);
    }

    public ResponseEntity<UserClass> RatingHotelFallback(String userId, Exception ex){
        log.info("fallback is called coz service is down: "+ex.getMessage());
        UserClass user = UserClass.builder()
                .userId(userId)
                .about("service is down cant fetch data")
                .build();
        return ResponseEntity.ok(user);
    }
    @GetMapping
    public ResponseEntity<List<UserClass>> getallUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
}
