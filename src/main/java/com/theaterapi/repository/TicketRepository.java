package com.theaterapi.repository;

import com.theaterapi.model.Ticket;

import java.util.List;

//import com.theaterapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {
	List<Ticket> findByUsername(String username);
}
