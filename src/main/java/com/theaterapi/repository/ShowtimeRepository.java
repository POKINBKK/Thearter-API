package com.theaterapi.repository;


import com.theaterapi.model.Showtime;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShowtimeRepository extends MongoRepository<Showtime, String> {
    List<Showtime> findByMovieId(String id);
    List<Showtime> findByTheaterId(String id);
    List<Showtime> deleteByDate(String date);
    Boolean existsByDate(String date);
}
