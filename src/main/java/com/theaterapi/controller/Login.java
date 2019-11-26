package com.theaterapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")

public class Login {
    @RequestMapping("/")
    public String hello(){
        return "already login";
    }
}
