//this class is for Controller of movie (path: /api/movie)

package com.theaterapi.controller;

import com.theaterapi.model.Movie;
import com.theaterapi.model.Showtime;
//import com.theaterapi.model.User;
import com.theaterapi.service.MovieService;
import com.theaterapi.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "*")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private ShowtimeService showtimeService;

    //Get all movie
    @GetMapping()
    public ResponseEntity<?> getMovies() {
        List<Movie> movies = movieService.retrieveMovies();
        return ResponseEntity.ok(movies);
    }

    //get movie by _id
    @GetMapping("/{id}")
    public ResponseEntity<?> getMoviebyId(@PathVariable String id) {
        Optional<Movie> movie = movieService.retrieveMovie(id);
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

    //edit movie _id
    @PutMapping("/{id}")
    public ResponseEntity<?> putMovie(@PathVariable String id, @RequestBody Movie body) {
        Optional<?> movie = movieService.updateMovie(id, body);
        return ResponseEntity.ok(movie);
    }

    //delete movie _id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable String id) {
        List<Showtime> showtimes = showtimeService.retrieveShowtimes();
        Boolean flag = false;
        for(Showtime tmpShow: showtimes){
            if((tmpShow.getMovieId()).equals(id)){
                flag = true;
                break;
            }
        }
        if(!movieService.deleteMovie(id) || flag) {
            System.out.println(flag);
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
