package com.theaterapi.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "user")
public class User {
    @Id
    private int userId;
    private String username;
}