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
public class CinemaService {
    private ShowtimeRepository showtimeRepository;
    private UserRepository userRepository;
    private MovieRepository movieRepository;

    @Autowired
    public CinemaService(ShowtimeRepository showtimeRepository, UserRepository userRepository,MovieRepository movieRepository) {
        this.showtimeRepository = showtimeRepository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    @Autowired
    private MongoTemplate mongoTemplate;

//    public List<Showtime> seeShowtime(){
//        return
//    }

    public List<Showtime> seeShowtime() {
        return showtimeRepository.findAll();
    }

    public List<Showtime> seeShowtimebyMovie(String movieName){
        Query query = new Query();
        query.addCriteria(Criteria.where("movieName").is(movieName));
        return mongoTemplate.find(query, Showtime.class);

    }

    public Showtime createShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    public List<User> showUser() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<Movie> findMovie(String name){
        Query query = new Query();
        query.addCriteria(Criteria.where("movieName").is(name));
        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        return movies;
    }
}
