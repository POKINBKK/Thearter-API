package com.theaterapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.theaterapi.model.Ticket;
import com.theaterapi.repository.TicketRepository;

@Service
public class TicketService {
	private TicketRepository ticketRepository;

	@Autowired
	public TicketService(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	public List<Ticket> retrieveTickeybyUsername(String username) {
		return this.ticketRepository.findByUsername(username);
	}

	public Ticket createTicket(Ticket body) {
		return ticketRepository.save(body);
	}

}
