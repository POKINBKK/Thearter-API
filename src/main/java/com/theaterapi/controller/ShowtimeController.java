package com.theaterapi.controller;


import com.theaterapi.model.Showtime;
import com.theaterapi.model.Theater;
import com.theaterapi.service.MovieService;
import com.theaterapi.service.ShowtimeService;
import com.theaterapi.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showtime")
public class ShowtimeController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private TheaterService theaterService;
    @Autowired
    private ShowtimeService showtimeService;

    //get all showtimes
    @GetMapping()
    public ResponseEntity<?> getShowtimes() {
        List<Showtime> showtimes = showtimeService.retrieveShowtimes();
        return ResponseEntity.ok(showtimes);
    }

    //get showtime by theaterid /showtime?theater=...
    @GetMapping(params = "theater")
    public ResponseEntity<?> getShowtimebyTheaterId(@RequestParam String theater) {
        List<Showtime> showtimes = showtimeService.retrieveShowtimebyTheater(theater);
        return ResponseEntity.ok(showtimes);
    }

    //get showtime by movieid /showtime?movie=...
    @GetMapping(params = "movie")
    public ResponseEntity<?> getShowtimebyMovieId(@RequestParam String movie) {
        List<Showtime> showtimes = showtimeService.retrieveShowtimebyMovie(movie);
        return ResponseEntity.ok(showtimes);
    }

    //create new Showtime
    @PostMapping()
    public ResponseEntity<?> postShowtime(@RequestBody Showtime body) {
        Showtime showtime = showtimeService.createShowtime(body);
        String theaterid = showtime.getTheaterId();
        List<Theater> theater = theaterService.retrieveTheater(theaterid);
        showtime.setAvailableSeats((theater.get(0)).getSeats());
        return ResponseEntity.status(HttpStatus.CREATED).body(showtime);
    }



}
