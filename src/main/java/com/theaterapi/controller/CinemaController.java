package com.theaterapi.controller;

import com.theaterapi.model.Movie;
import com.theaterapi.model.Showtime;
import com.theaterapi.model.User;
import com.theaterapi.service.CinemaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

//    @GetMapping("/showtime")
//    public List<Showtime> getAllShowtime(){
//
//    }

    @GetMapping("/{name}")
    public List<Movie> see(@PathVariable String name){
        return cinemaService.findMovie(name);
    }

    @GetMapping("/showtimes")
    public ResponseEntity<?> getShowtime(){
        List<Showtime> showtimes = cinemaService.seeShowtime();
        return ResponseEntity.ok(showtimes);
    }

    @GetMapping("/showtimes/{movieName}")
    public ResponseEntity<?> getShowtimebyMovie(@PathVariable String movieName){
        List<Showtime> showtimes = cinemaService.seeShowtimebyMovie(movieName);
        return ResponseEntity.ok(showtimes);
    }

    @PostMapping("/add-showtime")
    public ResponseEntity<?> postShowtime(@RequestBody Showtime showtime) {
        Showtime showtimes = cinemaService.createShowtime(showtime);
        return ResponseEntity.status(HttpStatus.CREATED).body(showtimes);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUser(){
        List<User> users = cinemaService.showUser();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/adduser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        System.out.println(user);
        User users = cinemaService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }
}
