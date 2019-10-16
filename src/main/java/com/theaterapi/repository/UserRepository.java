package com.theaterapi.repository;

import com.theaterapi.model.User;

import java.util.List;

//import com.theaterapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	List<User> findByUsername(String username);
	
}
