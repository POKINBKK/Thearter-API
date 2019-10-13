package com.theaterapi.controller;

import com.theaterapi.model.Theater;
import com.theaterapi.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    //Get all theater
    @GetMapping()
    public ResponseEntity<?> getTheaters() {
        List<Theater> theaters = theaterService.retrieveTheaters();
        return ResponseEntity.ok(theaters);
    }

    //get theater by theaterid
    @GetMapping("/{id}")
    public ResponseEntity<?> getTheaterbyId(@PathVariable String id) {
        List<Theater> theater = theaterService.retrieveTheater(id);
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

    //edit Theater
    @PutMapping("/{id}")
    public ResponseEntity<?> putTheater(@PathVariable String id, @RequestBody Theater body) {
        Optional<?> theater = theaterService.updateTheater(id, body);
        return ResponseEntity.ok(theater);
    }

    //delete Theater
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTheater(@PathVariable String id) {
        if(!theaterService.deleteTheater(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
