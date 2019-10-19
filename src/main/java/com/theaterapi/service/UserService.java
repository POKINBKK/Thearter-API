package com.theaterapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.theaterapi.model.Ticket;
import com.theaterapi.model.User;
import com.theaterapi.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> retrieveTickets() {
		return userRepository.findAll();
	}

	public Optional<User> retrieveTickeybyUsername(String username) {
		return this.userRepository.findById(username);
	}

	public User createTicket(User body) {
		User tmp_user = new User();
		ArrayList<Ticket> tmp_list_ticket = new ArrayList<Ticket>();
		Ticket tmp_ticket = new Ticket(body.getTickets().get(0).getMovieId(), body.getTickets().get(0).getTheaterId(), body.getTickets().get(0).getTime(), body.getTickets().get(0).getDate(), body.getTickets().get(0).getSeats());
		
		Optional<User> userOpt = userRepository.findById(body.getUsername());
		if(userOpt.isPresent()){
			// add old value
			for (Ticket temp : userOpt.get().getTickets()) {
				tmp_list_ticket.add(temp);
			}
		}
		// add new value
		tmp_list_ticket.add(tmp_ticket);
		
		tmp_user.setUsername(body.getUsername());
		tmp_user.setTickets(tmp_list_ticket);
		return this.userRepository.save(tmp_user);

	}

}
