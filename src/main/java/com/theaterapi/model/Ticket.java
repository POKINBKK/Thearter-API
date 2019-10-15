/*
This Class is For User Model included
username as ID (use outer user service so id is not a good idea.. i guess)
tickets for all ticket that this use have (with Ticket class for ticket object)
*/
package com.theaterapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

import javax.validation.constraints.NotNull;

@Data
public class Ticket {
    @Id
    private String username;
    @NotNull
    private int movieId;
    @NotNull
    private int theaterId;
    private String time;
    private String date;
    private List<String> seats;
//    private List<Ticket> tickets;
//
//    class Ticket {
//        private int movieId;
//        private int theaterId;
//        private String time;
//        private String date;
//        private List<String> seats;
//    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
}