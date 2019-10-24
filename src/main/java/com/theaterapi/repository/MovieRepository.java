package com.theaterapi.repository;

import com.theaterapi.model.Movie;
import com.theaterapi.model.Showtime;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
