/*
This Class is For Showtime Model included
id for Auto Generated ID
movieId for Query Movie's Data from MovieDB
theaterId for Query theater's Data from theaterDB
date for Date of this Showtime
time for Time of this Showtime (1 Showtime object : 1 time Only)
status for If Showtime Time has passed status will be FALSE
availableSeats for all availableseat Query from TheaterDB
unavailableSeats for all unavailableseat after user paid it
*/
package com.theaterapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
public class Showtime {
    @Id
    private String id;
    private int movieId;
    private int theaterId;
    private String date;
    private String time;
    private Boolean status;
    private List<String> availableSeats;
    private List<String> unavailableSeats;
}
