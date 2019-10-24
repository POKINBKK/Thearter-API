/*
This Class is For User Model included
username as ID (use outer user service so id is not a good idea.. i guess)
tickets for all ticket that this use have (with Ticket class for ticket object)
*/
package com.theaterapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;


@Data
public class User {
	@Id
	@Indexed(unique=true)
	private String username;
	private List<Ticket> tickets;
	
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}