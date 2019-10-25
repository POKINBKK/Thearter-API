package com.theaterapi.controller;

import com.theaterapi.model.Showtime;
import com.theaterapi.model.Theater;
import com.theaterapi.service.ShowtimeService;
import com.theaterapi.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theater")
@CrossOrigin(origins = "*")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;
    @Autowired
    private ShowtimeService showtimeService;

    //Get all theater
    @GetMapping()
    public ResponseEntity<?> getTheaters() {
        List<Theater> theaters = theaterService.retrieveTheaters();
        return ResponseEntity.ok(theaters);
    }

    //get theater by theaterid
    @GetMapping("/{id}")
    public ResponseEntity<?> getTheaterbyId(@PathVariable String id) {
        Optional<Theater> theater = theaterService.retrieveTheater(id);
        if(theater.equals(null)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(theater);
    }

    //create new theater
    @PostMapping()
    public ResponseEntity<?> postTheater(@RequestBody Theater body) {
        Theater theater = theaterService.createTheater(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(theater);
    }

    //delete Theater
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTheater(@PathVariable String id) {
        List<Showtime> showtimes = showtimeService.retrieveShowtimes();
        Boolean flag = false;
        for(Showtime tmpShow: showtimes){
            if((tmpShow.getTheaterId()).equals(id)){
                flag = true;
                break;
            }
        }
        if(!theaterService.deleteTheater(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Cannot delete theater _id: %s :Cause this _id not in database", id));
        } else if(flag) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Cannot delete theater _id: %s :Cause this _id in use in showtime db", id));
        } else{
            return ResponseEntity.ok(String.format("Delete theater _id: %s Complete", id));
        }
    }

    //edit Theater not use because theater after construction should not change architecture
//    @PutMapping("/{id}")
//    public ResponseEntity<?> putTheater(@PathVariable String id, @RequestBody Theater body) {
//        Optional<?> theater = theaterService.updateTheater(id, body);
//        return ResponseEntity.ok(theater);
//    }

}
