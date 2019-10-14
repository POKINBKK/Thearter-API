package com.theaterapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theaterapi.model.Showtime;
import com.theaterapi.model.Theater;
import com.theaterapi.model.Ticket;
import com.theaterapi.service.MovieService;
import com.theaterapi.service.TicketService;

@RestController
@RequestMapping("/history")
public class TicketController {
	@Autowired
	private TicketService ticketService;

	@GetMapping("/{username}")
	public ResponseEntity<?> getHistory(@PathVariable String id) {
		List<Ticket> ticket = ticketService.retrieveTickeybyUsername(id);
		if(ticket.equals(null)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ticket);
	}

}
