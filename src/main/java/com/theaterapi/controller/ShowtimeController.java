package com.theaterapi.controller;


import com.theaterapi.service.MovieService;
import com.theaterapi.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/showtime")
public class ShowtimeController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private TheaterService theaterService;
}
