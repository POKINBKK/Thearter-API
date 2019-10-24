/*
This Class is For Movie Model included
movieId for ID
movieName for Name
movieThumbnail for Picture of Movie
movieDescription for Short Description of Movie
*/

package com.theaterapi.model;

import lombok.Data;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
public class Movie {
	@Id
	@Indexed(unique=true)
    private String _id;
    @NotNull
    private String movieName;
    @NotNull
    private String movieThumbnail;
    @NotNull
    private String movieReleaseDate;
    private String movieLength;
    private String movieDescription;

    public String get_id() {
		return _id;
	}

    public String getMovieName() {
        return movieName;
    }

    public String getMovieThumbnail() {
        return movieThumbnail;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public String getMovieLength() {
        return movieLength;
    }

    public String getMovieDescription() {
        return movieDescription;
    }
}
