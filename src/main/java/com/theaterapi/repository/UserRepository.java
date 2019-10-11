package com.theaterapi.repository;

import com.theaterapi.model.Movie;
import com.theaterapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
