package com.theaterapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.theaterapi.model.User;
import com.theaterapi.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> retrieveUserTickets() {
		return userRepository.findAll();
	}

	public Optional<User> retrieveUserTicketbyUsername(String username) {
		return this.userRepository.findById(username);
	}

	public User createUserTicket(User user) {
		return this.userRepository.save(user);
	}

	//update User by username
	public Optional<User> updateUser(User user) {
		Optional<User> userOpt = userRepository.findByUsername(user.getUsername());
		if(!userOpt.isPresent()) {
			return userOpt;
		}
		user.setUsername(user.getUsername());
		return Optional.of(userRepository.save(user));
	}

	public boolean deleteUser(String id) {
		if(userRepository.existsById(id)){
			userRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}

}
