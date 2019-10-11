package com.theaterapi.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Document(collection = "movie")
public class Movie {
    @Id
    private int movieId;
    private String movieName;
    private String movieThumbnail;
    private String movieDescription;
}
