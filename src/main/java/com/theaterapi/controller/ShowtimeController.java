package com.theaterapi.controller;


import com.theaterapi.model.Movie;
import com.theaterapi.model.Showtime;
import com.theaterapi.model.Theater;
import com.theaterapi.service.MovieService;
import com.theaterapi.service.ShowtimeService;
import com.theaterapi.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/showtime")
public class ShowtimeController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private TheaterService theaterService;
    @Autowired
    private ShowtimeService showtimeService;

    //get all showtimes
    @GetMapping()
    public ResponseEntity<?> getShowtimes() {
        //For Retrieve Information
        List<Showtime> showtimes = showtimeService.retrieveShowtimes();
        List<Movie> movies = movieService.retrieveMovies();
        //For Response As it could be
        List<ShowtimeResponse> responseList = new ArrayList<ShowtimeResponse>();
        //For get movie Info by id in loop
        Movie movie = new Movie();
        for(Showtime tmp: showtimes){
            ShowtimeResponse tmpRes = new ShowtimeResponse();
            tmpRes.setId(tmp.getId());
            tmpRes.setMovieId(tmp.getMovieId());
            tmpRes.setTheaterId(tmp.getTheaterId());
            tmpRes.setDate(tmp.getDate());
            tmpRes.setTime(tmp.getTime());
            tmpRes.setStatus(tmp.getStatus());
            //This Part for movie Information
            for(Movie tmpMovie: movies){
                if((tmpMovie.getMovieId()).equals(tmpRes.getMovieId())){
                    movie = tmpMovie;
                }
            }
            tmpRes.setMovieName(movie.getMovieName());
            tmpRes.setMovieThumbnail(movie.getMovieThumbnail());
            tmpRes.setMovieReleaseDate(movie.getMovieReleaseDate());
            tmpRes.setMovieLength(movie.getMovieLength());
            tmpRes.setMovieDescription(movie.getMovieDescription());
            responseList.add(tmpRes);
        }
        return ResponseEntity.ok(responseList);
    }

    //get showtime by Id
    @GetMapping("/{id}")
    public ResponseEntity<?> getShowtime(@PathVariable String id) {
        //For Retrieve Information
        Optional<Showtime> showtime = showtimeService.retrieveShowtime(id);
        List<Movie> movies = movieService.retrieveMovies();
        //For Response As it could be
        //For get movie Info by id in loop
        Movie movie = new Movie();
        ShowtimeResponse tmpRes = new ShowtimeResponse();
        tmpRes.setId(showtime.get().getId());
        tmpRes.setMovieId(showtime.get().getMovieId());
        tmpRes.setTheaterId(showtime.get().getTheaterId());
        tmpRes.setDate(showtime.get().getDate());
        tmpRes.setTime(showtime.get().getTime());
        tmpRes.setStatus(showtime.get().getStatus());
        //This Part for movie Information
        for(Movie tmpMovie: movies){
            if((tmpMovie.getMovieId()).equals(tmpRes.getMovieId())){
                movie = tmpMovie;
            }
        }
        tmpRes.setMovieName(movie.getMovieName());
        tmpRes.setMovieThumbnail(movie.getMovieThumbnail());
        tmpRes.setMovieReleaseDate(movie.getMovieReleaseDate());
        tmpRes.setMovieLength(movie.getMovieLength());
        tmpRes.setMovieDescription(movie.getMovieDescription());
        return ResponseEntity.ok(tmpRes);
    }

    //get showtime by theaterid /showtime?theater=...
    @GetMapping(params = "theater")
    public ResponseEntity<?> getShowtimebyTheaterId(@RequestParam String theater) {
        List<Showtime> showtimes = showtimeService.retrieveShowtimebyTheater(theater);
        List<Movie> movies = movieService.retrieveMovies();
        //For Response As it could be
        List<ShowtimeResponse> responseList = new ArrayList<ShowtimeResponse>();
        //For get movie Info by id in loop
        Movie movie = new Movie();
        for(Showtime tmp: showtimes){
            ShowtimeResponse tmpRes = new ShowtimeResponse();
            tmpRes.setId(tmp.getId());
            tmpRes.setMovieId(tmp.getMovieId());
            tmpRes.setTheaterId(tmp.getTheaterId());
            tmpRes.setDate(tmp.getDate());
            tmpRes.setTime(tmp.getTime());
            tmpRes.setStatus(tmp.getStatus());
            //This Part for movie Information
            for(Movie tmpMovie: movies){
                if((tmpMovie.getMovieId()).equals(tmpRes.getMovieId())){
                    movie = tmpMovie;
                }
            }
            tmpRes.setMovieName(movie.getMovieName());
            tmpRes.setMovieThumbnail(movie.getMovieThumbnail());
            tmpRes.setMovieReleaseDate(movie.getMovieReleaseDate());
            tmpRes.setMovieLength(movie.getMovieLength());
            tmpRes.setMovieDescription(movie.getMovieDescription());
            responseList.add(tmpRes);
        }
        return ResponseEntity.ok(responseList);
    }

    //get showtime by movieid /showtime?movie=...
    @GetMapping(params = "movie")
    public ResponseEntity<?> getShowtimebyMovieId(@RequestParam String movie) {
        List<Showtime> showtimes = showtimeService.retrieveShowtimebyMovie(movie);
        List<Movie> movies = movieService.retrieveMovies();
        //For Response As it could be
        List<ShowtimeResponse> responseList = new ArrayList<ShowtimeResponse>();
        //For get movie Info by id in loop like above just change name
        Movie movieDetail = new Movie();
        for(Showtime tmp: showtimes){
            ShowtimeResponse tmpRes = new ShowtimeResponse();
            tmpRes.setId(tmp.getId());
            tmpRes.setMovieId(tmp.getMovieId());
            tmpRes.setTheaterId(tmp.getTheaterId());
            tmpRes.setDate(tmp.getDate());
            tmpRes.setTime(tmp.getTime());
            tmpRes.setStatus(tmp.getStatus());
            //This Part for movie Information
            for(Movie tmpMovie: movies){
                if((tmpMovie.getMovieId()).equals(tmpRes.getMovieId())){
                    movieDetail = tmpMovie;
                }
            }
            tmpRes.setMovieName(movieDetail.getMovieName());
            tmpRes.setMovieThumbnail(movieDetail.getMovieThumbnail());
            tmpRes.setMovieReleaseDate(movieDetail.getMovieReleaseDate());
            tmpRes.setMovieLength(movieDetail.getMovieLength());
            tmpRes.setMovieDescription(movieDetail.getMovieDescription());
            responseList.add(tmpRes);
        }
        return ResponseEntity.ok(responseList);
    }

    //create new Showtime
    @PostMapping()
    public ResponseEntity<?> postShowtime(@RequestBody Showtime body) {
        Showtime tmp = body;
        String theaterid = tmp.getTheaterId();
        List<Theater> theater = theaterService.retrieveTheater(theaterid);
        tmp.setAvailableSeats((theater.get(0)).getSeats());
        Showtime showtime = showtimeService.createShowtime(tmp);
        return ResponseEntity.status(HttpStatus.CREATED).body(showtime);
    }

    //edit Showtime
    @PutMapping("/{id}")
    public ResponseEntity<?> putShowtime(@PathVariable String id, @RequestBody Showtime body) {
        Optional<?> showtime = showtimeService.updateShowtime(id, body);
        return ResponseEntity.ok(showtime);
    }

    //delete Showtime
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShowtime(@PathVariable String id) {
        if(!showtimeService.deleteShowtime(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    //class for response of showtime
    private class ShowtimeResponse {
        private String id;
        private String movieId;
        private String theaterId;
        private String movieName;
        private String movieThumbnail;
        private String movieReleaseDate;
        private String movieLength;
        private String movieDescription;
        private String time;
        private String date;
        private Boolean status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMovieId() {
            return movieId;
        }

        public void setMovieId(String movieId) {
            this.movieId = movieId;
        }

        public String getTheaterId() {
            return theaterId;
        }

        public void setTheaterId(String theaterId) {
            this.theaterId = theaterId;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getMovieThumbnail() {
            return movieThumbnail;
        }

        public void setMovieThumbnail(String movieThumbnail) {
            this.movieThumbnail = movieThumbnail;
        }

        public String getMovieReleaseDate() {
            return movieReleaseDate;
        }

        public void setMovieReleaseDate(String movieReleaseDate) {
            this.movieReleaseDate = movieReleaseDate;
        }

        public String getMovieLength() {
            return movieLength;
        }

        public void setMovieLength(String movieLength) {
            this.movieLength = movieLength;
        }

        public String getMovieDescription() {
            return movieDescription;
        }

        public void setMovieDescription(String movieDescription) {
            this.movieDescription = movieDescription;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Boolean getStatus() {
            return status;
        }

        public void setStatus(Boolean status) {
            this.status = status;
        }
    }



}
