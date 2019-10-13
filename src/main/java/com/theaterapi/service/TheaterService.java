package com.theaterapi.service;

import com.theaterapi.model.Theater;
import com.theaterapi.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    private TheaterRepository theaterRepository;

    @Autowired
    public TheaterService(TheaterRepository theaterRepository){
        this.theaterRepository = theaterRepository;
    }

    public List<Theater> retrieveTheaters() {
        return theaterRepository.findAll();
    }

    public List<Theater> retrieveTheater(String id) {
        return theaterRepository.findByTheaterId(id);
    }

    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public Optional<Theater> updateTheater(String id, Theater theater) {
        Optional<Theater> theaterOpt = theaterRepository.findById(id);
        if(!theaterOpt.isPresent()) {
            return theaterOpt;
        }
        theater.setId(id);
        return Optional.of(theaterRepository.save(theater));
    }

    public boolean deleteTheater(String id) {
        try {
            theaterRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
