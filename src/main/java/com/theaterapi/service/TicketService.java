package com.theaterapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theaterapi.model.Showtime;
import com.theaterapi.model.Ticket;
import com.theaterapi.repository.MovieRepository;
import com.theaterapi.repository.ShowtimeRepository;
import com.theaterapi.repository.TicketRepository;


@Service
public class TicketService {
	private TicketRepository ticketRepository;
	 @Autowired
	    public TicketService(TicketRepository ticketRepository){
	        this.ticketRepository = ticketRepository;
	    }

	    public List<Ticket> retrieveTickeybyUsername(String Id) {
	        return ticketRepository.findByUserId(Id);
	    }

}
