package com.theaterapi.service;

import com.theaterapi.model.Showtime;
import com.theaterapi.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Showtime> retrieveShowtime(String id) {
        return showtimeRepository.findById(id);
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

    public Optional<Showtime> updateShowtime(String id, Showtime showtime) {
        Optional<Showtime> showtimeOpt = showtimeRepository.findById(id);
        if(!showtimeOpt.isPresent()) {
            return showtimeOpt;
        }
        showtime.set_id(id);
        return Optional.of(showtimeRepository.save(showtime));
    }

    public boolean deleteShowtime(String id) {
        if(showtimeRepository.existsById(id)) {
            showtimeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteShowtimebyDate(String date) {
        if(showtimeRepository.existsByDate(date)) {
            showtimeRepository.deleteByDate(date);
            return true;
        } else {
            return false;
        }
    }
}
