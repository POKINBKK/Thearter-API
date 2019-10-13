package com.theaterapi.service;

import com.theaterapi.model.Movie;
import com.theaterapi.model.Showtime;
import com.theaterapi.model.User;
import com.theaterapi.repository.MovieRepository;
import com.theaterapi.repository.ShowtimeRepository;
import com.theaterapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //Get all Movie Detail
    public List<Movie> retrieveMovies() {
        return movieRepository.findAll();
    }

    //Get movie by movieId
    public List<Movie> retrieveMovie(String id) {
        return movieRepository.findByMovieId(id);
    }

    //create Movie
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    //update movie by id
    public Optional<Movie> updateMovie(String id, Movie movie) {
        Optional<Movie> movieOpt = movieRepository.findById(id);
        if(!movieOpt.isPresent()) {
            return movieOpt;
        }
        movie.setId(id);
        return Optional.of(movieRepository.save(movie));
    }

    //delete movie by id
    public boolean deleteMovie(String id) {
        try {
            movieRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
