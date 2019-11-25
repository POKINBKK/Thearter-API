package com.theaterapi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkuser")
@CrossOrigin(origins = "*")
public class CheckUserController {
    @RequestMapping("/")
    String home(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = null;
        try {
            username = authentication.getName();
            System.out.println(authentication.getName());
            System.out.println(authentication.getDetails().toString());
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return username;
    }
}
