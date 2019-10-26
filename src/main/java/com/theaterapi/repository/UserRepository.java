package com.theaterapi.repository;

import com.theaterapi.model.User;

import java.util.List;
import java.util.Optional;

//import com.theaterapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findByUsername(String username);
	
}
