package com.gureev.webapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping()
public class UserController {

    @GetMapping("/login")
    public boolean login(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();

        String l = new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
        String p = new String(Base64.getDecoder()
                .decode(authToken)).split(":")[1];

        boolean isRight = l.equals("user") && p.equals("password");

        System.out.println("login=" + l);
        System.out.println("password=" + p);
        System.out.println("isRight=" + isRight);

        return isRight;
    }

    @GetMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () -> new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }

}
