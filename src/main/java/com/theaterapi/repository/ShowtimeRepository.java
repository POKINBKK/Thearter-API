package com.theaterapi.repository;


import com.theaterapi.model.Showtime;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShowtimeRepository extends MongoRepository<Showtime, String> {

}
