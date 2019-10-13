package com.theaterapi.repository;

import com.theaterapi.model.Theater;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TheaterRepository extends MongoRepository<Theater, String> {
    List<Theater> findByTheaterId(String id);
}
