package com.theaterapi.controller;

import com.theaterapi.config.AuthenticationSystem;
import com.theaterapi.cookie.CookieUtil;
import com.theaterapi.cookie.JwtUtil;
import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/checkuser")
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = {"*"})
public class CheckUserController {
    @GetMapping("/")
    Map<String, String> home(Principal principal, HttpServletResponse httpServletResponse){


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());

        HashMap<String, String> map = new HashMap<>();
        if(authentication.getName() != "anonymousUser"){
            String token = JwtUtil.generateToken("userSigning", authentication.getName());
            CookieUtil.create(httpServletResponse, "jwt-token", token, false, -1, "34.87.24.186");
        }
        map.put("user", authentication.getName());
        return map;

    }
}
