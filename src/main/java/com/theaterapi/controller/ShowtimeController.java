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
@CrossOrigin(origins = "*")
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
            tmpRes.setId(tmp.get_id());
            tmpRes.setMovieId(tmp.getMovieId());
            tmpRes.setTheaterId(tmp.getTheaterId());
            tmpRes.setDate(tmp.getDate());
            tmpRes.setTime(tmp.getTime());
            tmpRes.setStatus(tmp.getStatus());
            //This Part for movie Information
            for(Movie tmpMovie: movies){
                if((tmpMovie.get_id()).equals(tmpRes.getMovieId())){
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

    //get showtime by _id
    @GetMapping(params = "id")
    public ResponseEntity<?> getShowtime(@RequestParam String id) {
        //For Retrieve Information
        Optional<Showtime> showtime = showtimeService.retrieveShowtime(id);
        if(!showtime.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot get This showtime :Cause this _id not in database");
        }
        return ResponseEntity.ok(showtime);
    }

    //get showtime by theaterid /showtime?theater={theater._id}
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
            tmpRes.setId(tmp.get_id());
            tmpRes.setMovieId(tmp.getMovieId());
            tmpRes.setTheaterId(tmp.getTheaterId());
            tmpRes.setDate(tmp.getDate());
            tmpRes.setTime(tmp.getTime());
            tmpRes.setStatus(tmp.getStatus());
            //This Part for movie Information
            for(Movie tmpMovie: movies){
                if((tmpMovie.get_id()).equals(tmpRes.getMovieId())){
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
        if(responseList.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot get This showtime :Cause this theater _id not in database or no showtime in this theater");
        }
        return ResponseEntity.ok(responseList);
    }

    //get showtime by movieid /showtime?movie={movie._id}
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
            tmpRes.setId(tmp.get_id());
            tmpRes.setMovieId(tmp.getMovieId());
            tmpRes.setTheaterId(tmp.getTheaterId());
            tmpRes.setDate(tmp.getDate());
            tmpRes.setTime(tmp.getTime());
            tmpRes.setStatus(tmp.getStatus());
            //This Part for movie Information
            for(Movie tmpMovie: movies){
                if((tmpMovie.get_id()).equals(tmpRes.getMovieId())){
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
        if(responseList.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot get This showtime :Cause this movie _id not in database or no showtime use this movie");
        }
        return ResponseEntity.ok(responseList);
    }

    //create new Showtime
    @PostMapping()
    public ResponseEntity<?> postShowtime(@RequestBody Showtime body) {
        Showtime tmp = body;
        List<Showtime> showtimes = showtimeService.retrieveShowtimes();
        Optional<Theater> theater = theaterService.retrieveTheater(tmp.getTheaterId());
        if(!theater.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Cannot select theater _id: %s :Cause this _id not in database", tmp.getTheaterId()));
        }
        Optional<Movie> movie = movieService.retrieveMovie(tmp.getMovieId());
        if(!movie.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Cannot select movie _id: %s :Cause this _id not in database", tmp.getMovieId()));
        }
        tmp.setAvailableSeats(theater.get().getSeats());
        for(Showtime tmpshow: showtimes){
            if((tmpshow.getTheaterId()).equals(tmp.getTheaterId()) && (tmpshow.getDate()).equals(tmp.getDate()) && (tmpshow.getTime()).equals(tmp.getTime())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot add This showtime :Cause this time in this theater already in database");
            }
        }
        Showtime showtime = showtimeService.createShowtime(tmp);
        return ResponseEntity.status(HttpStatus.CREATED).body(showtime);
    }


    //delete Showtime by _id api/showtime?id={_id}
    @DeleteMapping(params = "id")
    public ResponseEntity<?> deleteShowtime(@RequestParam String id) {
        if(!showtimeService.deleteShowtime(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Cannot delete showtime _id: %s :Cause this _id not in database", id));
        }
        return ResponseEntity.ok(String.format("Delete showtime _id: %s Complete", id));
    }

    //delete Showtime by Date api/showtime?date={date}
    @DeleteMapping(params = "date")
    public ResponseEntity<?> deleteShowtimebyDate(@RequestParam String date) {
        if(!showtimeService.deleteShowtimebyDate(date)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Cannot delete showtime date: %s :Cause this date not in database", date));
        }
        return ResponseEntity.ok(String.format("Delete showtime date: %s Complete", date));
    }

    //edit Showtime
    @PutMapping("/{id}")
    public ResponseEntity<?> putShowtime(@PathVariable String id, @RequestBody Showtime body) {
        Optional<?> showtime = showtimeService.updateShowtime(id, body);
        return ResponseEntity.ok(showtime);
    }

    //class for response of showtime
    private class ShowtimeResponse {
        private String _id;
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
            return _id;
        }

        public void setId(String id) {
            this._id = id;
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
