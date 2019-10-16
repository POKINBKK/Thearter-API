package com.theaterapi.model;

import java.util.List;

import lombok.Data;

@Data
public class Ticket {
	private int movieId;
	private int theaterId;
	private String time;
	private String date;
	private List<String> seats;

	public Ticket() {
	}

	public Ticket(int movieId, int theaterId, String time, String date, List<String> seats) {
		super();
		this.movieId = movieId;
		this.theaterId = theaterId;
		this.time = time;
		this.date = date;
		this.seats = seats;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<String> getSeats() {
		return seats;
	}

	public void setSeats(List<String> seats) {
		this.seats = seats;
	}
}
