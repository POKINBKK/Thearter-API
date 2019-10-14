package com.theaterapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.theaterapi.model.Ticket;
import com.theaterapi.service.TicketService;

@RestController
//@RequestMapping("/history")
public class TicketController {
	@Autowired
	private TicketService ticketService;
	
//	Ticket History by user
	@GetMapping("history/{username}")
	public ResponseEntity<?> getHistory(@PathVariable String id) {
		List<Ticket> ticket = ticketService.retrieveTickeybyUsername(id);
		if(ticket.equals(null)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ticket);
	}
	
//	Add ticket
    @PostMapping()
    public ResponseEntity<?> postMovie(@RequestBody Ticket body) {
        Ticket ticket = ticketService.createTicket(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }

}
