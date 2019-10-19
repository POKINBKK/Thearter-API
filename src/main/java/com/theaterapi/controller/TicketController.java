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
import com.theaterapi.model.User;
import com.theaterapi.service.UserService;


@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private UserService userService;

// all ticket	
	@GetMapping()
    public ResponseEntity<?> getCustomers() {
        List<User> ticket = userService.retrieveTickets();
        return ResponseEntity.ok(ticket);
    }

//	Ticket History by user
	@GetMapping("/{username}")
	public ResponseEntity<?> getHistory(@PathVariable String username) {
		Optional<?>ticket = userService.retrieveTickeybyUsername(username);
		if (!ticket.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(ticket);
	}

//	Add ticket
	@PostMapping()
	public ResponseEntity<?> postTicket(@RequestBody User body) {
		User ticket = userService.createTicket(body);
		return new ResponseEntity<User>(ticket, HttpStatus.OK);
//		return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
	}

}
