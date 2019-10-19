//this class is for Controller of movie (path: /api/movie)

package com.theaterapi.controller;

import com.theaterapi.model.Movie;
import com.theaterapi.model.Showtime;
//import com.theaterapi.model.User;
import com.theaterapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    //Get all movie
    @GetMapping()
    public ResponseEntity<?> getMovies() {
        List<Movie> movies = movieService.retrieveMovies();
        return ResponseEntity.ok(movies);
    }

    //get movie by movieId
    @GetMapping("/{id}")
    public ResponseEntity<?> getMoviebyId(@PathVariable String id) {
        Movie movie = movieService.retrieveMovie(id);
        if(movie.equals(null)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(movie);
    }

    //create new movie
    @PostMapping()
    public ResponseEntity<?> postMovie(@RequestBody Movie body) {
        Movie movie = movieService.createMovie(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    //edit movie id
    @PutMapping("/{id}")
    public ResponseEntity<?> putMovie(@PathVariable String id, @RequestBody Movie body) {
        Optional<?> movie = movieService.updateMovie(id, body);
        return ResponseEntity.ok(movie);
    }

    //delete movie id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable String id) {
        if(!movieService.deleteMovie(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
