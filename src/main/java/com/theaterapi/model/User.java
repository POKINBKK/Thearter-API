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

@Data
@Document(collection = "user")
public class User {
    @Id
    private String username;
    private List<Ticket> tickets;

    class Ticket {
        private int movieId;
        private int theaterId;
        private String time;
        private String date;
        private List<String> seats;
    }
}