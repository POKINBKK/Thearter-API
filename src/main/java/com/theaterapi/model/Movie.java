/*
This Class is For Movie Model included
movieId for ID
movieName for Name
movieThumbnail for Picture of Movie
movieDescription for Short Description of Movie
*/

package com.theaterapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "movie")
public class Movie {
    @Id
    private int movieId;
    private String movieName;
    private String movieThumbnail;
    private String movieDescription;
}
