package com.theaterapi.model;

import java.util.List;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class Ticket {
	@Id
	@Indexed(unique=true)
	private String _id;
	private String username;
	private String showtimeId;
	private List<String> seats;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(String showtimeId) {
		this.showtimeId = showtimeId;
	}

	public List<String> getSeats() {
		return seats;
	}

	public void setSeats(List<String> seats) {
		this.seats = seats;
	}

	public Ticket() {
	}

	public Ticket(String showtimeId, List<String> seats) {
		this.showtimeId = showtimeId;
		this.seats = seats;
	}
}
