package com.theaterapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.theaterapi.model.Ticket;
import com.theaterapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.theaterapi.model.User;
import com.theaterapi.service.UserService;


@RestController
@RequestMapping("/u")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private TicketService ticketService;

// get all user information
	@GetMapping()
    public ResponseEntity<?> getUsers() {
        List<User> ticket = userService.retrieveUserTickets();
        return ResponseEntity.ok(ticket);
    }

//	Ticket History by user
	@GetMapping("/{username}")
	public ResponseEntity<?> getHistory(@PathVariable String username) {
		Optional<?>ticket = userService.retrieveUserTicketbyUsername(username);
		if (!ticket.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Cannot get user username: %s :Cause this username not in database", username));
		}
		return ResponseEntity.ok(ticket);
	}

//	Add ticket
	@PostMapping()
	public ResponseEntity<?> postTicket(@RequestBody Ticket body) {
		//create new ticket from request body
		Ticket new_ticket = ticketService.createTicket(body);
		//new empty list for store ticket(old(if exist)+new)
		List<String> tmp_userticket = new ArrayList<String>();
		String userid;
		//get userdata if they in db
		Optional<User> user = userService.retrieveUserTicketbyUsername(body.getUsername());
		if(user.isPresent()){
			//get old ticket(yes they are just string of ticket _id)
			for(String old_ticketId: user.get().getTickets()){
				tmp_userticket.add(old_ticketId);
			}
		}
		//add new ticket to list (add just _id)
		tmp_userticket.add(new_ticket.get_id());

		User new_info = new User();
		new_info.setUsername(body.getUsername());
		new_info.setTickets(tmp_userticket);
		User ticket = userService.createUserTicket(new_info);
		return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
	}

	// get all ticket information
	@GetMapping("/ticket")
	public ResponseEntity<?> getTickets() {
		List<Ticket> tickets = ticketService.retrieveTickets();
		return ResponseEntity.ok(tickets);
	}
	// get all ticket information
	@GetMapping("/ticket/{id}")
	public ResponseEntity<?> getTicket(@PathVariable String id) {
		Optional<Ticket> ticket = ticketService.retrieveTicket(id);
		if(!ticket.isPresent()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Cannot get ticket _id: %s :Cause this _id not in database", id));
		}
		return ResponseEntity.ok(ticket);
	}

	@DeleteMapping("/ticket/{id}")
	public ResponseEntity<?> removeTicket(@PathVariable String id) {
		//get ticket that want to delete
		Optional<Ticket> ticket = ticketService.retrieveTicket(id);
		if(!ticket.isPresent()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Cannot delete ticket _id: %s :Cause this _id not in database", id));
		}
		//get username from that ticket id
		String username = ticket.get().getUsername();
		//get user (for list of ticket they have)
		Optional<User> user = userService.retrieveUserTicketbyUsername(username);
		if (!user.isPresent()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Cannot delete ticket _id: %s :Cause this username who use this ticket not in database", id));
		}
		//ticket that they have
		List<String> curr_tickets = user.get().getTickets();
		//remove what you want
		curr_tickets.remove(id);
		//create temp for update
		User updated_user = new User();
		updated_user.setUsername(user.get().getUsername());
		updated_user.setTickets(curr_tickets);
		//update data to userdb
		userService.updateUser(updated_user);
		//delete ticket from ticket db
		ticketService.deleteTicket(id);
		return ResponseEntity.ok(String.format("Delete ticket _id: %s Complete", id));
	}
}
