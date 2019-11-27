package com.theaterapi.controller;

import com.theaterapi.cookie.CookieUtil;
import com.theaterapi.cookie.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController

@CrossOrigin(origins = "*")

public class Login {
    @RequestMapping("/login")
    public ResponseEntity<Object> home(Principal principal, HttpServletResponse httpServletResponse)  throws URISyntaxException {
//    public Map<String, String> home(Principal principal, HttpServletResponse httpServletResponse){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());

        HashMap<String, String> map = new HashMap<>();
        if(authentication.getName() != "anonymousUser"){
            String token = JwtUtil.generateToken("userSigning", authentication.getName());
            CookieUtil.create(httpServletResponse, "jwt-token", token, false, -1, "34.87.24.186");
        }
        map.put("user", authentication.getName());
//        return  map;
        URI yahoo = new URI("http://34.87.24.186/");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(yahoo);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);

    }
}
