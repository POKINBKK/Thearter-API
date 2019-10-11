package com.theaterapi.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@Document(collection = "showtime")
public class Showtime {
    @Id
    private int showtimeId;
    private String movieName;
    private String theaterId;
    private List<String> time;
    private String date;
}
