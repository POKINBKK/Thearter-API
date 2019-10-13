package com.theaterapi.service;

import com.theaterapi.model.Showtime;
import com.theaterapi.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowtimeService {
    private ShowtimeRepository showtimeRepository;

    @Autowired
    public ShowtimeService(ShowtimeRepository showtimeRepository){
        this.showtimeRepository = showtimeRepository;
    }

    public List<Showtime> retrieveShowtimes() {
        return showtimeRepository.findAll();
    }

    public List<Showtime> retrieveShowtimebyTheater(String id) {
        return showtimeRepository.findByTheaterId(id);
    }

    public List<Showtime> retrieveShowtimebyMovie(String id) {
        return showtimeRepository.findByMovieId(id);
    }

    public Showtime createShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }
}
